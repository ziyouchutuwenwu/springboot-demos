package com.demo.annotationaspect;

import org.springframework.stereotype.Component;

@Component
public class AnnotationDemo {
    @MyAnnotation
    public String hi(String msg) {
        return "Hi , this is SayHello. " + msg;
    }
}