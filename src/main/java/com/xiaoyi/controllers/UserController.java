package com.xiaoyi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaoyi.models.User;
import com.xiaoyi.services.UserService;
import com.xiaoyi.tool.DataConverter;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public HttpHeaders getJsonHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return headers;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody String userString) {
        var params = DataConverter.convertFormData(userString);
        User user = User.builder()
                .username(params.get(USERNAME))
                .password(params.get(PASSWORD))
                .role("user")
                .build();

        authWithoutPassword(user);
        userService.insertUserToDB(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/login-success")
    public ResponseEntity<String> apiDefaultTarget() throws JsonProcessingException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userJson = new ObjectMapper().writeValueAsString(authentication);
        return new ResponseEntity<>(userJson, getJsonHeaders(), HttpStatus.OK);
    }

    @GetMapping("/login-page")
    public ResponseEntity<String> apiLoginPage() {
        return new ResponseEntity<>(getJsonHeaders(), HttpStatus.UNAUTHORIZED);
    }   


    @GetMapping("/authentication-failure")
    public ResponseEntity<String> apiAuthenticationFail() {
        return new ResponseEntity<>("{\"success\" : false, \"message\" : \"authentication-failure\"}",
                getJsonHeaders(), HttpStatus.OK);
    }

    public void authWithoutPassword(User user){

        GrantedAuthority grantedAuthority = UserService.getUserAuthority(user.getRole());

        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, List.of(grantedAuthority));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
