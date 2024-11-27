package com.nexign.springDemo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component

public class Address {

    private String street;

    private String city;

    public Address() {
    }

    public Address(@Value("${address.street}")String street, @Value("${address.city}") String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Address) obj;
        return Objects.equals(this.street, that.street) &&
                Objects.equals(this.city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city);
    }

    @Override
    public String toString() {
        return "Address[" +
                "street=" + street + ", " +
                "city=" + city + ']';
    }

}
