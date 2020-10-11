package com.mybatis.demo.controller;

import com.mybatis.demo.entity.User;
import com.mybatis.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    // curl http://127.0.0.1:8081/user/1
    @RequestMapping(value="/user/{id}",method= RequestMethod.GET)
    public User findUser(@PathVariable("id")Long id){
        User user = userService.getUserById(id);
        return user;
    }
}