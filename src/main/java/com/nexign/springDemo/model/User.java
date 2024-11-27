package com.nexign.springDemo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

    private Address address;
    private int id;

    @Autowired
    public User(Address address) {
        this(0, address);
    }

    public User(int id, Address address) {
        this.address = address;
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
               "address=" + address +
               ", id=" + id +
               '}';
    }
    //IoC <- DI
}
