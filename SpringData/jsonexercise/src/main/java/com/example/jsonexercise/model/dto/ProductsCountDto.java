package com.example.jsonexercise.model.dto;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ProductsCountDto {
    @Expose
    private Integer count;
    @Expose
    private List<ProductNamePriceDto> products;

    public ProductsCountDto() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ProductNamePriceDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductNamePriceDto> products) {
        this.products = products;
    }
}
