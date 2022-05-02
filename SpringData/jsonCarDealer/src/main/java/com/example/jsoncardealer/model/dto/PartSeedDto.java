package com.example.jsoncardealer.model.dto;

import com.google.gson.annotations.Expose;


import java.math.BigDecimal;

public class PartSeedDto {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private Integer quantity;

    public PartSeedDto() {
    }

    public String getName() {
        return name;
    }

    public PartSeedDto setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public PartSeedDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public PartSeedDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
