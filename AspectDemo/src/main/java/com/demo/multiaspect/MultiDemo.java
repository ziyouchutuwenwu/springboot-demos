package com.demo.multiaspect;

import org.springframework.stereotype.Component;

@Component
public class MultiDemo {
    public String hi(String msg) {
        return "Hi " + msg;
    }
}