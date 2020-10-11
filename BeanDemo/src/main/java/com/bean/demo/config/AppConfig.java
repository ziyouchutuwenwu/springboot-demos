package com.bean.demo.config;

import com.bean.demo.model.Book;
import com.bean.demo.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /*
    * @Bean(name="aaa")
    * 或者
    * @Bean
    * @Qualifier("aaa")
    * @Bean保证在spring容器里面是单例
    * 配置类里面定义多个bean, 在 autowired的时候指定引用
    * */
    @Bean
    @Qualifier("aaa")
    public Book getBook1() {
        Book book = new Book();
        book.title = "书aaa";
        return book;
    }

    /*
    * @Configuration 加上 @Bean修饰的方法会被spring自动调用,形成单例
    * */
    @Bean(name="bbb")
    public Book getBook2() {
        Book book = new Book();
        book.title = "书bbb";
        return book;
    }

    @Bean(name="ccc")
    public Person getPerson1(@Qualifier("aaa") Book book) {
        Person person = new Person();
        person.name = "人名ccc";
        person.book = book;
        return person;
    }

    @Bean(name="ddd")
    public Person getPerson2(@Qualifier("bbb") Book book) {
        Person person = new Person();
        person.name = "人名ddd";
        person.book = book;
        return person;
    }
}