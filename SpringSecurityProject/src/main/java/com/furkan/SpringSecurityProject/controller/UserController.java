package com.furkan.SpringSecurityProject.controller;

import com.furkan.SpringSecurityProject.model.User;
import com.furkan.SpringSecurityProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

   // all user

    @RequestMapping("/all")
    public List<User> getUserList(){
        return this.userService.getUserList();
    }
    // return single user

    @RequestMapping("/name")
    public User getUser(@PathVariable("name") String name){
        return this.userService.getUser(name);
    }

    // add user

    @PostMapping("/add")

    public User addUser(User user){
        return this.userService.addUser(user);
    }
}
