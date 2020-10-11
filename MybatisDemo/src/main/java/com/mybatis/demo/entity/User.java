package com.mybatis.demo.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class User implements Serializable {

    private Long userId;
    private String userName;
    private String address;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}