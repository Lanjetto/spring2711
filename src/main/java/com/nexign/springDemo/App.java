package com.nexign.springDemo;


import com.nexign.springDemo.config.BeanConfig;
import com.nexign.springDemo.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BeanConfig.class);
        User bean = context.getBean(User.class);
        System.out.println(bean);
    }
}
