package com.xiaoyi.controllers;

import com.xiaoyi.models.User;
import com.xiaoyi.services.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    public String login(String username, String password) {
        return userService.login(username, password);
    }

    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

    public void logout() {
        userService.logout();
    }
}
