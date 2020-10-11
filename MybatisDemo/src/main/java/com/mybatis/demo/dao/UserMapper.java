package com.mybatis.demo.dao;

import com.mybatis.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insertUser(User userEntity);
    User selectByPrimaryKey(Long userId);
    User selectByName(String userName);
}