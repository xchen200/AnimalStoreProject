package com.xiaoyi.controllers;

import com.xiaoyi.models.User;
import com.xiaoyi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public List<User> findAll() {return userService.findAll();}

    @RequestMapping(value = "/login/username/{username}/password/{password}",
            method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> login(@PathVariable String username, @PathVariable String password) {
        Optional<User> user = userService.findByUserName(username).stream().findFirst();
        if (user.isPresent() && user.get().getPassword().equals(password)) {

            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @PostMapping(value = "/login")
//    public String login(@RequestParam Map<String, String> body) {
//
//        String username = body.get(USERNAME);
//        String password = body.get(PASSWORD);
//
//        Optional<User> user = userService.findByUserName(username).stream().findFirst();
//        if (user.isPresent() && user.get().getPassword().equals(password)) {
//
//            return "redirect:/";
//        } else {
//            return "redirect:/login";
//        }
//    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login";
    }

    public void logout() {
        userService.logout();
    }
}
