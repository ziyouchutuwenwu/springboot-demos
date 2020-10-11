package com.mybatis.demo.service;

import com.mybatis.demo.dao.UserMapper;
import com.mybatis.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getUserById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}