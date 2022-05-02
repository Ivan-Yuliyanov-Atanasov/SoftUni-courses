package com.example.jsoncardealer.model.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class PartViewDto {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;

    public PartViewDto() {

    }

    public String getName() {
        return name;
    }

    public PartViewDto setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public PartViewDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
