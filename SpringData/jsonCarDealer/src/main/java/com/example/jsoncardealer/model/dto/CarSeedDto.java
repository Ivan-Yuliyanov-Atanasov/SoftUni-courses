package com.example.jsoncardealer.model.dto;

import com.google.gson.annotations.Expose;



public class CarSeedDto {

    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private Long travelledDistance;

    public CarSeedDto() {
    }

    public String getMake() {
        return make;
    }

    public CarSeedDto setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarSeedDto setModel(String model) {
        this.model = model;
        return this;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public CarSeedDto setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
        return this;
    }
}
