package com.xiaoyi.controllers;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoyi.models.Animal;
import com.xiaoyi.models.Orders;
import com.xiaoyi.models.User;
import com.xiaoyi.services.AnimalStorageService;

@Controller
public class AnimalPurchaseController {

    @Autowired
    private AnimalStorageService animalStorageService;

//    public void purchaseAnimal(Animal animal) {
//        try {
////            userService.pay(animal.getPrice());
//            animalService.sellerAnimal(animal.getId());
//        } catch (NegativeBalanceException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    
    @RequestMapping("buy")
    @ResponseBody
    public String buy(Integer goodid,HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getName().equals("anonymousUser")) {
        	return "login";
        }
        Animal goods = animalStorageService.queryAnimalById(goodid);
        Orders order = (Orders) session.getAttribute("order");
		if (order==null) {
			session.setAttribute("order", animalStorageService.add(goods));
		}else {
			session.setAttribute("order", animalStorageService.addOrderItem(order, goods));
		}
		return "ok";
    }
	@RequestMapping("/cart")
	public String cart(Model model) {
		return "cart";
	}
	
	/**
	 * reduce
	 */
	@RequestMapping("/lessen")
	public @ResponseBody String lessen(int goodid, HttpSession session){
		Orders order = (Orders) session.getAttribute("order");
		if (order != null) {
			session.setAttribute("order", animalStorageService.lessenIndentItem(order, animalStorageService.queryAnimalById(goodid)));
		}
		return "ok";
	}
	
	/**
	 * delete
	 */
	@RequestMapping("/delete")
	public @ResponseBody String delete(int goodid, HttpSession session){
		Orders order = (Orders) session.getAttribute("order");
		if (order != null) {
			session.setAttribute("order", animalStorageService.deleteIndentItem(order, animalStorageService.queryAnimalById(goodid)));
		}
		return "ok";
	}
	
	
	/**
	 * submit order
	 * @return
	 */
	@RequestMapping("/save")
	public String save(ServletRequest request, HttpSession session, Model model){
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if(authentication.getName().equals("anonymousUser")) {
	        	request.setAttribute("msg", "Please log in and submit!");
	        	return "cart";
	        }
		Orders sessionOrder = (Orders) session.getAttribute("order");
		if (sessionOrder != null) {
			sessionOrder.setUsername(authentication.getName());
			int orderid = animalStorageService.saveOrder(sessionOrder);	// sava order
			session.removeAttribute("order");	// delete cart
			return "redirect:topay?orderid="+orderid;
		}
		request.setAttribute("msg", "Processing failed!");
		return "cart";
	}
	
	/**
	 * payment page
	 * @return
	 */
	@RequestMapping("/topay")
	public String topay(int orderid, ServletRequest request, Model model) {
		request.setAttribute("order", animalStorageService.selectOrderById(orderid));
		return "pay";
	}
	
	/**
	 * Pay (simulation)
	 * @return
	 */
	@RequestMapping("/pay")
	public String pay(Orders order, Model model) {
		animalStorageService.pay(order);
		return "redirect:payok?orderid="+order.getId();
	}
	
	/**
	 * 支付成功
	 * @return
	 */
	@RequestMapping("/payok")
	public String payok(int orderid, ServletRequest request, Model model) {
		Orders order = animalStorageService.selectOrderById(orderid);
		int paytype = order.getPaytype();
		if(paytype == Orders.PAYTYPE_WECHAT || paytype == Orders.PAYTYPE_ALIPAY) {
			request.setAttribute("msg", "order["+orderid+"]payment successful");
		}else {
			request.setAttribute("msg", "order["+orderid+"]cash on delivery");
		}
		return "payok";
	}
	
	/**
	 * check order
	 * @return
	 */
	@RequestMapping("/order")
	public String order(HttpSession session, Model model){
		model.addAttribute("flag", 3);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		List<Orders> orderList = animalStorageService.getListByUserName(authentication.getName());
		if (orderList!=null && !orderList.isEmpty()) {
			for(Orders order : orderList){
				order.setItemList(animalStorageService.getOrderItemList(order.getId()));
			}
		}
		model.addAttribute("orderList", orderList);
		return "order";
	}
	
	
}
