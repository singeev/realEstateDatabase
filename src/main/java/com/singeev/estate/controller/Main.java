package com.singeev.estate.controller;

import com.singeev.estate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String welcome() {
        return "index";
    }

    @RequestMapping("/admin")
    public String showAdmin(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin";
    }
}
