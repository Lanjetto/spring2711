package com.nexign.springDemo;

import com.nexign.springDemo.factory.ApplicationContext;
import com.nexign.springDemo.model.User;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext();
        User bean = context.getBean(User.class);
        System.out.println(bean);
    }
}
