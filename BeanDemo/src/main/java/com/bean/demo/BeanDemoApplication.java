package com.bean.demo;

import com.bean.demo.model.Book;
import com.bean.demo.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})

/*
* 这是 lombok 提供的一个注解，lombok 会向 Demo01Application 类中注入一个 log 变量
* 需要idea安装lombok插件,否则提示log不存在
* */
@Slf4j
public class BeanDemoApplication implements CommandLineRunner {

    @Autowired
    @Qualifier("aaa")
    private Book _book;

    @Autowired
    @Qualifier("ccc")
    private Person _person;

    public static void main(String[] args) {
        SpringApplication.run(BeanDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("theBook.title: {}", _book.title);
        log.info("thePerson.name: {}", _person.name);
        log.info("thePerson.theBook.title: {}", _person.book.title);
    }
}