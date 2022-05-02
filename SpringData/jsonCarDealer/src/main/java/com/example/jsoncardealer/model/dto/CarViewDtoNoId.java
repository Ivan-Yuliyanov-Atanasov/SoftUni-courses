package com.example.jsoncardealer.model.dto;

import com.google.gson.annotations.Expose;

public class CarViewDtoNoId {
    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private Long travelledDistance;

    public CarViewDtoNoId() {
    }

    public String getMake() {
        return make;
    }

    public CarViewDtoNoId setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarViewDtoNoId setModel(String model) {
        this.model = model;
        return this;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public CarViewDtoNoId setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
        return this;
    }
}
