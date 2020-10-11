package com.demo;

import com.demo.annotationaspect.AnnotationDemo;
import com.demo.multiaspect.MultiDemo;
import com.demo.simpleaspect.SimpleDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@Slf4j
public class AspectDemoApplication implements CommandLineRunner {

    @Autowired
    private SimpleDemo simpleDemo;

    @Autowired
    private MultiDemo multiDemo;

    @Autowired
    private AnnotationDemo annotationDemo;

    @Override
    public void run(String... args) throws Exception {
        log.info("result: " + simpleDemo.hi("simpleDemo"));
        log.info("result: " + multiDemo.hi("multiDemo"));
        log.info("result: " + annotationDemo.hi("annotationDemo"));
    }

    public static void main(String[] args) {
        SpringApplication.run(AspectDemoApplication.class, args);
    }
}