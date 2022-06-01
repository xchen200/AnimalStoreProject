package com.xiaoyi.services;

import com.xiaoyi.models.User;
import com.xiaoyi.storages.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final Map<String, User> userMap;

    private User currentUser;

    public UserService() {
        userMap = new HashMap<>();
    }

    public String login(String username, String password) {
//        if (userMap.containsKey(username) && userMap.get(username).getPassword().equals(password)) {
//            currentUser = userMap.get(username);
//            return String.format("User %s login success", username);
//        }
        return "username not exist or password mismatch";
    }

    public String register(String username, String password, String mobile, String email) {

        if (userMap.containsKey(username)) {
            return String.format("User %s already exists", username);
        }

//        User newUser = User.builder()
//                .username(username)
//                .password(password)
//                .mobile(mobile)
//                .email(email)
//                .build();

//        userMap.put(username, newUser);
        return String.format("Successfully register user %s", username);
    }

    public String register(User user) {
//        if (userMap.containsKey(user.getUsername())) {
//            return String.format("User %s already exists", user.getUsername());
//        }
//        userMap.put(user.getUsername(), user);
//        return String.format("Successfully register user %s", user.getUsername());
        return null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void pay(BigDecimal amount) {
//        currentUser.getPayment().pay(amount);
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM customers";

        List<User> users = jdbcTemplate.query(sql, new UserRowMapper());

        return users;
    }

    public List<User> findByUserName(String username) {

        String sql = "SELECT * FROM customers WHERE name = ?";

        return jdbcTemplate.query(sql, new UserRowMapper(), username);
    }

    public void logout() {
        currentUser = null;
    }
}
