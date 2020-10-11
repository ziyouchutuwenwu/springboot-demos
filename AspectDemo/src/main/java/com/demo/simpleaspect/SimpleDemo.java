package com.demo.simpleaspect;

import org.springframework.stereotype.Component;

@Component
public class SimpleDemo {
    public String hi(String msg) {
        return "Hi " + msg;
    }
}