package com.example.jsoncardealer.model.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class SaleInfoDto {
    @Expose
    private CarViewDtoNoId car;
    @Expose
    private String customerName;
    @Expose
    private Double discount;
    @Expose
    private BigDecimal price;
    @Expose
    private BigDecimal priceWithDiscount;

    public SaleInfoDto() {
    }

    public CarViewDtoNoId getCar() {
        return car;
    }

    public SaleInfoDto setCar(CarViewDtoNoId car) {
        this.car = car;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public SaleInfoDto setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public Double getDiscount() {
        return discount;
    }

    public SaleInfoDto setDiscount(Double discount) {
        this.discount = discount;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public SaleInfoDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public SaleInfoDto setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
        return this;
    }
}
