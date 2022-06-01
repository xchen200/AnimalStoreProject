package com.xiaoyi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


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
    public String homePage(Model model) {
        return "home";
    }

}
