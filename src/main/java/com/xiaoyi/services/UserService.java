package com.xiaoyi.services;

import com.xiaoyi.models.User;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class UserService {

    private final Map<String, User> userMap;

    private User currentUser;

    public UserService() {
        userMap = new HashMap<>();
    }

    public String login(String username, String password) {
        if (userMap.containsKey(username) && userMap.get(username).getPassword().equals(password)) {
            currentUser = userMap.get(username);
            return String.format("User %s login success", username);
        }
        return "username not exist or password mismatch";
    }

    public String register(String username, String password, String mobile, String email) {

        if (userMap.containsKey(username)) {
            return String.format("User %s already exists", username);
        }

        User newUser = User.builder()
                .username(username)
                .password(password)
                .mobile(mobile)
                .email(email)
                .build();

        userMap.put(username, newUser);
        return String.format("Successfully register user %s", username);
    }

    public String register(User user) {
        if (userMap.containsKey(user.getUsername())) {
            return String.format("User %s already exists", user.getUsername());
        }
        userMap.put(user.getUsername(), user);
        return String.format("Successfully register user %s", user.getUsername());
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void pay(BigDecimal amount) {
        currentUser.getPayment().pay(amount);
    }

    public void logout() {
        currentUser = null;
    }
}
