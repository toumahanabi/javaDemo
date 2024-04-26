package com.example.javademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/index")
    public String index(Model model){
        return "index";
    }

    @RequestMapping(value = "/admin/oldLogin")
    public String login(Model model){
        return "login";
    }
}
