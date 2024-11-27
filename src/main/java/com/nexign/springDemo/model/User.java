package com.nexign.springDemo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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

    public User() {
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //IoC <- DI
}
