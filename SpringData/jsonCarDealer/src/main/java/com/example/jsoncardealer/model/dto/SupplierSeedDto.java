package com.example.jsoncardealer.model.dto;

import com.google.gson.annotations.Expose;

import javax.persistence.Column;

public class SupplierSeedDto {

    @Expose
    private String name;
    @Expose
    private boolean isImporter;

    public SupplierSeedDto() {
    }

    public String getName() {
        return name;
    }

    public SupplierSeedDto setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public SupplierSeedDto setImporter(boolean importer) {
        isImporter = importer;
        return this;
    }
}
