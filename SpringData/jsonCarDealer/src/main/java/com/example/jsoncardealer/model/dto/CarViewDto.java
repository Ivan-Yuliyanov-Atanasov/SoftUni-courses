package com.example.jsoncardealer.model.dto;

import com.google.gson.annotations.Expose;

public class CarViewDto {
    @Expose
    private Long id;
    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private Long travelledDistance;

    public CarViewDto() {
    }

    public Long getId() {
        return id;
    }

    public CarViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMake() {
        return make;
    }

    public CarViewDto setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarViewDto setModel(String model) {
        this.model = model;
        return this;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public CarViewDto setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
        return this;
    }
}
