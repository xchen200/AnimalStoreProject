package com.xiaoyi.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.xiaoyi.exceptions.EntityNotFoundException;
import com.xiaoyi.models.Animal;
import com.xiaoyi.models.Items;
import com.xiaoyi.models.Orders;
import com.xiaoyi.storages.AnimalMapper;
import com.xiaoyi.storages.ItemsRowMapper;
import com.xiaoyi.storages.OrdersRowMapper;

@Service
public class AnimalStorageService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //TODO: Implement for Admin
    public void insertOrUpdate(Animal animal) {
        if (animal.getId() != null) {
            /* Update */
        } else {
            /* Insert */
        }
    }

    public Animal queryAnimalById(long id) {
        String sql = "SELECT * FROM animals WHERE id = ?";

        List<Animal> animals = jdbcTemplate.query(sql, new AnimalMapper(), id);

        if (animals.isEmpty()) {
            throw new EntityNotFoundException("Animal not found for id: " + id);
        } else {
            return animals.get(0);
        }
    }

    public List<Animal> getAnimalByType(String type) {
        String sql = "SELECT * FROM animals WHERE subtype = ?";

        return jdbcTemplate.query(sql, new AnimalMapper(), type);
    }

    public List<Animal> getAllAnimals() {
        String sql = "SELECT * FROM animals";

        List<Animal> animals = jdbcTemplate.query(sql, new AnimalMapper());

        return animals;
    }

//    public List<Animal> queryAnimal(AnimalType animalType, BigDecimal lowestPrice, BigDecimal highestPrice, String subType) {
//
//        List<Animal> queryResults = new ArrayList<>(animalMap.values());
//
//        if (animalType != null) {
//            queryResults = queryResults.stream()
//                    .filter(animal -> animal.getAnimalType().equals(animalType))
//                    .collect(Collectors.toList());
//        }
//
//        if (lowestPrice != null) {
//            queryResults = queryResults.stream()
//                    .filter(animal -> animal.getPrice().compareTo(lowestPrice) >= 0)
//                    .collect(Collectors.toList());
//        }
//
//        if (highestPrice != null) {
//            queryResults = queryResults.stream()
//                    .filter(animal -> animal.getPrice().compareTo(highestPrice) <= 0)
//                    .collect(Collectors.toList());
//        }
//
//        if (subType != null) {
//            queryResults = queryResults.stream()
//                    .filter(animal -> animal.getSubType().equalsIgnoreCase(subType))
//                    .collect(Collectors.toList());
//        }
//
//        return queryResults;
//    }
    /**
	 * 创建订单
	 * @param good
	 * @return
	 */
	public Orders add(Animal good) {
		List<Items> itemList = new ArrayList<Items>();
		itemList.add(addItem(good));
		Orders order = Orders.builder().build();
		order.setItemList(itemList);
		order.setTotal(good.getPrice());
		order.setAmount(1);
		return order;
	}

	/**
	 * 向订单添加项目
	 * @param order
	 * @param good
	 * @return
	 */
	public Orders addOrderItem(Orders order, Animal good) {
		List<Items> itemList = order.getItemList();
		itemList = itemList==null ? new ArrayList<Items>() : itemList;
		// 如果购物车已有此项目, 数量+1
		boolean notThis = true;
		for (Items item : itemList) {
			if (item.getGoodId() == good.getId()) {
				item.setAmount(item.getAmount() + 1);
				item.setTotal(good.getPrice() * item.getAmount());
				notThis = false;
			}
		}
		// 如果当前购物车没有此项目, 创建新条目
		if (notThis) {
			itemList.add(addItem(good));
		}
		order.setTotal(order.getTotal() + good.getPrice());
		order.setAmount(order.getAmount() + 1);
		return order;
	}
	/**
	 * 创建订单项
	 * @param good
	 * @return
	 */
	private Items addItem(Animal good) {
		Items item = Items.builder().build();
		item.setGoodId(good.getId());
		item.setAmount(1);
		item.setPrice(good.getPrice());
		item.setTotal(good.getPrice());
		item.setAnimal(queryAnimalById(item.getGoodId()));
		return item;
	}
	
	/**
	 * 从订单中减少项目
	 * @param order
	 * @param good
	 * @return
	 */
	public Orders lessenIndentItem(Orders order, Animal good) {
		List<Items> itemList = order.getItemList();
		itemList = itemList==null ? new ArrayList<Items>() : itemList;
		// 如果购物车已有此项目, 数量-1
		boolean noneThis = true;
		for (Items item : itemList) {
			if (item.getGoodId() == good.getId()) {
				if (item.getAmount() - 1 <= 0) { // 减少到0后删除
					return deleteIndentItem(order, good);
				}
				item.setAmount(item.getAmount() - 1);
				item.setTotal(good.getPrice() * item.getAmount());
				noneThis = false;
			}
		}
		// 如果当前购物车没有项目, 直接返回
		if (noneThis) {
			return order;
		}
		order.setTotal(order.getTotal() - good.getPrice());
		order.setAmount(order.getAmount() - 1);
		return order;
	}
	
	/**
	 * 从订单中删除项目
	 * @param order
	 * @param good
	 * @return
	 */
	public Orders deleteIndentItem(Orders order, Animal good) {
		List<Items> itemList = order.getItemList();
		itemList = itemList==null ? new ArrayList<Items>() : itemList;
		// 如果购物车已有此项目, 数量清零
		boolean noneThis = true;
		int itemAmount = 0;
		List<Items> resultList = new ArrayList<Items>();
		for (Items item : itemList) {
			if (item.getGoodId() == good.getId()) {
				itemAmount = item.getAmount();
				noneThis = false;
				continue;
			}
			resultList.add(item);
		}
		// 如果已经没有项目, 返回null
		if (resultList.isEmpty()) {
			return null;
		}
		order.setItemList(resultList);
		// 如果当前购物车没有项目, 直接返回
		if (noneThis) {
			return order;
		}
		order.setTotal(order.getTotal() - good.getPrice() * itemAmount);
		order.setAmount(order.getAmount() - itemAmount);
		return order;
	}

	/**
	 * 保存订单
	 * @param order
	 */
	public int saveOrder(Orders order) {
		order.setStatus(Orders.STATUS_UNPAY);
		order.setSystime(new Date());
		insertOrder(order);
		int orderid = order.getId();
		for(Items item : order.getItemList()){
			item.setOrderId(orderid);
			insertItem(item);
		}
		return orderid;
	}
	
	private void insertItem(Items item) {
		String sql = "insert into items (price, amount, order_id, "
				+ "      good_id)"
				+ "    values ("+item.getPrice()+", "+item.getAmount()+", "+item.getOrderId()+","
				+ item.getGoodId()
				+")";
		jdbcTemplate.execute(sql);
		
	}

	private void insertOrder(Orders order) {
		String sql = "insert into orders (total, amount, status, "
				+ "      paytype, "
				+ "      user_name"
				+ "      )"
				+ "    values ("+order.getTotal()+","+order.getAmount()+", "+order.getStatus()+", "
				+ "      "+order.getPaytype()+", '"+order.getUsername()+"' "
				+ "      )";
//		jdbcTemplate.execute(sql);
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				return ps;
			}
		},holder);
		
		order.setId(holder.getKey().intValue());
	}

	/**
	 * 订单支付
	 * @param order
	 */
	public void pay(Orders order) {
		Orders old = selectOrderById(order.getId());
		// 微信或支付宝支付时, 模拟支付完成
		int paytype = order.getPaytype();
		if(paytype == Orders.PAYTYPE_WECHAT || paytype == Orders.PAYTYPE_ALIPAY) {
			old.setStatus(Orders.STATUS_PAYED);
		}else {
			old.setStatus(Orders.STATUS_SEND);
		}
		old.setPaytype(order.getPaytype());
		old.setName(order.getName());
		old.setPhone(order.getPhone());
		old.setAddress(order.getAddress());
		updateOrderById(old);
	}

	private void updateOrderById(Orders old) {
		String sql = "update orders set status="+old.getStatus()+", "
				+ "      paytype="+old.getPaytype()+", "
				+ "      name='"+old.getName()+"', "
				+ "      phone='"+old.getPhone()+"', "
				+ "      address='"+old.getAddress()+"' "
				+"  WHERE id = "+old.getId();
		jdbcTemplate.execute(sql);
	}

	public Orders selectOrderById(Integer id) {
		 String sql = "SELECT * FROM orders WHERE id = ?";

	        List<Orders> orders = jdbcTemplate.query(sql, new OrdersRowMapper(), id);

	        if (orders.isEmpty()) {
	            throw new EntityNotFoundException("Order not found for id: " + id);
	        } else {
	            return orders.get(0);
	        }
	}

	public List<Orders> getListByUserName(String username) {
		 String sql = "SELECT * FROM orders WHERE user_name = ?";

	     return jdbcTemplate.query(sql, new OrdersRowMapper(), username);

	}

	public List<Items> getOrderItemList(Integer orderid) {
		 String sql = "SELECT * FROM items WHERE order_id = ?";
		 List<Items> itemList = jdbcTemplate.query(sql, new ItemsRowMapper(), orderid);
			for(Items item : itemList) {
				item.setAnimal(queryAnimalById(item.getGoodId()));
			}
			return itemList;

	}
}
