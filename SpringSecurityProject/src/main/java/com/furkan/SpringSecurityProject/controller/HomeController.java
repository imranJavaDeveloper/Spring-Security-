package com.furkan.SpringSecurityProject.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {

    @RequestMapping("/home")
    public String home(){
        return "this is home page";
    }

    @RequestMapping("/login")
    public String login(){
        return "this is login page";
    }

    @RequestMapping("/register")
    public String register(){
        return "this is register page";
    }
}
