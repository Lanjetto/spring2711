package com.nexign.springDemo.model;

import java.util.Objects;

public class Address {
    private final String street;
    private final String city;

//    public Address(String street, String city) {
//        this.street = "street";
//        this.city = "city";
//    }

    public Address() {
        this.street = "street";
        this.city = "city";
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
