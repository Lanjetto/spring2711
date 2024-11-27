package com.nexign.springDemo;


import com.nexign.springDemo.config.BeanConfig;
import com.nexign.springDemo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BeanConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.addUser();
        userService.addUser();


    }
}
