package com.nexign.springDemo.entities;

import com.nexign.springDemo.model.CityType;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String street;
    private CityType cityType;

    public UserEntity() {
    }

    public UserEntity(Long id, String city, String street) {
        this.id = id;
        this.city = city;
        this.street = street;
    }

    public UserEntity(String city, String street, CityType cityType) {
        this.city = city;
        this.street = street;
        this.cityType = cityType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
