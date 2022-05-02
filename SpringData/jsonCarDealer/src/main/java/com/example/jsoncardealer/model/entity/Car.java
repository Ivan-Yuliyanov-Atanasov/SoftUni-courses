package com.example.jsoncardealer.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity{


    @Column
    private String make;
    @Column
    private String model;
    @Column(name = "travelled_distance")
    private Long travelledDistance;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Part> parts;


    public Set<Part> getParts() {
        return parts;
    }

    public Car setParts(Set<Part> parts) {
        this.parts = parts;
        return this;
    }



    public Car() {
    }

    public String getMake() {
        return make;
    }

    public Car setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public Car setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
        return this;
    }

    public BigDecimal totalPrice(){
        BigDecimal totalPrice = new BigDecimal("0");
        for (Part part : parts) {
            totalPrice = totalPrice.add(part.getPrice());

        }
        return totalPrice;
    }
}

