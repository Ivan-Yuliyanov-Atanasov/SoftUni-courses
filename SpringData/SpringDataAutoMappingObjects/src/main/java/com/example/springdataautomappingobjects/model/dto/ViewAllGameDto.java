package com.example.springdataautomappingobjects.model.dto;

public class ViewAllGameDto {

    private String title;
    private Double price;

    public ViewAllGameDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
