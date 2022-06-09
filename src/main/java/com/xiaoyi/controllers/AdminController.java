package com.xiaoyi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String showAdmin(Model model) {
    	model.addAttribute("msg","login success......");
        return "index";
    }
    @GetMapping("/adminLogin")
    public String adminLogin() {
        return "adminLogin";
    }
}
