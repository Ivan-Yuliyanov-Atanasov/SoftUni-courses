package com.example.jsoncardealer.model.dto;

import com.google.gson.annotations.Expose;

public class SupplierViewDto {

    @Expose
    private Long id;
    @Expose
    private String name;
    @Expose
    private Integer partsCount;

    public SupplierViewDto() {
    }

    public Long getId() {
        return id;
    }

    public SupplierViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SupplierViewDto setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPartsCount() {
        return partsCount;
    }

    public SupplierViewDto setPartsCount(Integer partsCount) {
        this.partsCount = partsCount;
        return this;
    }
}
