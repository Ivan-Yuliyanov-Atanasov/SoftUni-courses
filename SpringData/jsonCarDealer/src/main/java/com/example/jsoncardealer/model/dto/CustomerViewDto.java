package com.example.jsoncardealer.model.dto;

import com.example.jsoncardealer.model.entity.Sale;
import com.google.gson.annotations.Expose;

import java.time.LocalDateTime;
import java.util.Set;

public class CustomerViewDto {
    @Expose
    private Long id;
    @Expose
    private String name;
    @Expose
    private String birthDate;
    @Expose
    private boolean isYoungDriver;
    @Expose
    private Set<SaleViewDto> sales;

    public CustomerViewDto() {

    }

    public Long getId() {
        return id;
    }

    public CustomerViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CustomerViewDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public CustomerViewDto setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public CustomerViewDto setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
        return this;
    }

    public Set<SaleViewDto> getSales() {
        return sales;
    }

    public CustomerViewDto setSales(Set<SaleViewDto> sales) {
        this.sales = sales;
        return this;
    }
}
