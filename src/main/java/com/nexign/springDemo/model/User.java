package com.nexign.springDemo.model;

import com.nexign.springDemo.annotation.Inject;

public class User {
    private String name;
    private int age;
    @Inject
    private Address address;

//    public User(String name, int age, Address address) {
//        this.name = "name";
//        this.age = 12;
//        this.address = address;
//    }

    public User() {
        this.name = "name";
        this.age = 12;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    //IoC <- DI
}
