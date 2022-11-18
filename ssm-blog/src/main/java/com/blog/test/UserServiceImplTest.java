package com.blog.test;

import com.blog.service.UserService;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @org.junit.jupiter.api.Test
    void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService userService = (UserService) ac.getBean("UserService");
        userService.test();
    }
}