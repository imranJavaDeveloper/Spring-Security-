package com.furkan.SpringSecurityProject.service;
import com.furkan.SpringSecurityProject.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {

    List<User> list= new ArrayList<>();

    public UserService(){
        list.add(new User(" furkan","furkan@gmial.com","furkan@123"));
        list.add(new User(" adil","raja@gmial.com","raja@123"));
        list.add(new User(" Raja","raja@gmial.com","raja@123"));
    }

    // get all user

    public List<User> getUserList() {
        return this.list;
    }

    // get single user

    public User getUser(String name){
        return this.list.stream().filter((user)->user.getName().equals(name)).findAny().orElse(null);
    }

    public User addUser(User user){
        this.list.add(user);
        return user;
    }

}
