package com.xiaoyi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AnimalStoreController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL_USERS = "select * from customers";

    @RequestMapping("/users")
    public List<Map<String, Object>> getAllUsers(){
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(SELECT_ALL_USERS);
        System.out.println("Getting all users from DB: " + list);
        return list;
    }

}
