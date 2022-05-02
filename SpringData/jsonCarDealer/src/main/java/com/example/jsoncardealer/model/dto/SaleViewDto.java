package com.example.jsoncardealer.model.dto;

import com.google.gson.annotations.Expose;

public class SaleViewDto {
    @Expose
    private Long id;
    @Expose
    private String carMake;
    @Expose
    private String carModel;


    public SaleViewDto() {
    }

    public Long getId() {
        return id;
    }

    public SaleViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCarModel() {
        return carModel;
    }

    public SaleViewDto setCarModel(String carModel) {
        this.carModel = carModel;
        return this;
    }

    public String getCarMake() {
        return carMake;
    }

    public SaleViewDto setCarMake(String carMake) {
        this.carMake = carMake;
        return this;
    }
}
