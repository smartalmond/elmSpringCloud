package com.elm.user.controller;

import com.elm.user.pojo.User;
import com.elm.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/UserController")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUserByIdByPass")
    public User getUserByIdByPass(User user){
        return userService.getUserByIdByPass(user.getUserId(), user.getPassword());
    }

    @RequestMapping("/getUserById")
    public User getUserById(User user){
        return userService.getUserById(user.getUserId());
    }

    @RequestMapping("/saveUser")
    public int saveUser(User user){
        return userService.saveUser(user);
    }
}
