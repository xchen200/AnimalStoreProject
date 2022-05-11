package com.xiaoyi.controllers;

import com.xiaoyi.models.User;
import com.xiaoyi.services.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;

    public String register(String username, String password, String mobile, String email) {
        return userService.register(username, password, mobile, email);
    }

    public String register(User user) {
        return userService.register(user);
    }
}
