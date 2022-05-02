package com.example.jsoncardealer.model.dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class CarWithPartsViewDto {

    @Expose
    private CarViewDtoNoId car;

    @Expose
    private Set<PartViewDto> parts;

    public CarWithPartsViewDto() {
    }

    public CarViewDtoNoId getCar() {
        return car;
    }

    public CarWithPartsViewDto setCar(CarViewDtoNoId car) {
        this.car = car;
        return this;
    }

    public Set<PartViewDto> getParts() {
        return parts;
    }

    public CarWithPartsViewDto setParts(Set<PartViewDto> parts) {
        this.parts = parts;
        return this;
    }
}
