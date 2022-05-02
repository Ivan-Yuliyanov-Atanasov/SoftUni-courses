package com.example.xmlcardealer.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity{

    @Column
    private Integer discount;
    @ManyToOne
    private Customer customer;
    @OneToOne
    private Car car;

    public Sale() {
    }

    public Integer getDiscount() {
        return discount;
    }

    public Sale setDiscount(Integer discount) {
        this.discount = discount;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Sale setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Car getCar() {
        return car;
    }

    public Sale setCar(Car car) {
        this.car = car;
        return this;
    }
}
