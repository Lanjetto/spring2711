package com.nexign.springDemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class);

//        UserService userService = context.getBean(UserService.class);
//        userService.addUser();
//        userService.addUser();
//        System.out.println(userService.getUser(1));
//        System.out.println(userService.getUser(2));

//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(BeanConfig.class);
//        UserService userService = context.getBean(UserService.class);




    }
}
