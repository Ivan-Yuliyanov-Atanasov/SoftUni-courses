package com.example.jsoncardealer.model.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class CustomerSpentMoneyDto {
    @Expose
    private String fullName;
    @Expose
    private Integer boughtCars;
    @Expose
    private BigDecimal spentMoney;

    public CustomerSpentMoneyDto() {
    }

    public String getFullName() {
        return fullName;
    }

    public CustomerSpentMoneyDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Integer getBoughtCars() {
        return boughtCars;
    }

    public CustomerSpentMoneyDto setBoughtCars(Integer boughtCars) {
        this.boughtCars = boughtCars;
        return this;
    }

    public BigDecimal getSpentMoney() {
        return spentMoney;
    }

    public CustomerSpentMoneyDto setSpentMoney(BigDecimal spentMoney) {
        this.spentMoney = spentMoney;
        return this;
    }
}
