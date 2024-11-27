package com.nexign.springDemo.model;

public enum CityType {
    SMALL(1L), MED(2L), LARGE(3L);
    private Long id;

    CityType(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
