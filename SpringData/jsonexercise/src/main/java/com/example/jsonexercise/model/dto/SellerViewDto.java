package com.example.jsonexercise.model.dto;

import com.google.gson.annotations.Expose;

public class SellerViewDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer age;
    @Expose
    private ProductsCountDto soldProducts;

    public SellerViewDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ProductsCountDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductsCountDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
