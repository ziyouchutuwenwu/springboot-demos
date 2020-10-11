package com.mybatisplus.demo.mapper;

import com.mybatisplus.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void selectByMyWrapper() {
        List<User> users = userMapper.selectByName("Jack");
        users.forEach(System.out::println);
    }

    @Test
    public void testSelect() {
        List<User> userList = userMapper.selectList(null);
        for(User user:userList) {
            System.out.println(user);
        }
    }
}