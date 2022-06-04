package com.xiaoyi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AnimalStoreController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL_USERS = "select * from customers";

//    @RequestMapping("/users")
//    public List<Map<String, User>> getAllUsers(){
//        List<Map<String, Object>> list = jdbcTemplate.queryForList(SELECT_ALL_USERS);
//        System.out.println("Getting all users from DB: " + list);
//        return list;
//
//    }

    @GetMapping("/")
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        modelAndView.addObject("username", username);
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
