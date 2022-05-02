package com.example.jsoncardealer.model.dto;

import com.example.jsoncardealer.model.entity.Customer;
import com.google.gson.annotations.Expose;


import java.time.LocalDateTime;
import java.util.Date;

public class CustomerSeedDto {

    @Expose
    private String name;
    @Expose
    private String birthDate;
    @Expose
    private boolean isYoungDriver;

    public CustomerSeedDto() {
    }

    public String getName() {
        return name;
    }

    public CustomerSeedDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public CustomerSeedDto setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public CustomerSeedDto setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
        return this;
    }
}
