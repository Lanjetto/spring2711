package com.nexign.springDemo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
//@PropertySource("classpath:application.properties")
public class Address {
    private String street;

    private String city;

    public Address(@Value("${address.street}")String street,@Value("${address.city}") String city) {
        this.street = street;
        this.city = city;
    }

    public String street() {
        return street;
    }

    public String city() {
        return city;
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
