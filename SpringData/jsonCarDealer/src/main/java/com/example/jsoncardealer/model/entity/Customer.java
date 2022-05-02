package com.example.jsoncardealer.model.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity{

    @Column
    private String name;
    @Column(name = "birth_date")
    private LocalDateTime birthDate;
    @Column(name = "is_young_driver")
    private boolean isYoungDriver;
    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private Set<Sale> sales;

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public Customer setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public Customer setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
        return this;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public Customer setSales(Set<Sale> sales) {
        this.sales = sales;
        return this;
    }
}
