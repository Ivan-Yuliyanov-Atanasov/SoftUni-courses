package com.example.jsoncardealer.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "parts")
public class Part extends BaseEntity{
    @Column
    private String name;
    @Column
    private BigDecimal price;
    @Column
    private Integer quantity;
    @ManyToMany(mappedBy = "parts")
    private Set<Car> cars;
    @ManyToOne
    private Supplier supplier;

    public Part() {

    }

    public String getName() {
        return name;
    }

    public Part setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Part setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Part setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public Part setCars(Set<Car> cars) {
        this.cars = cars;
        return this;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Part setSupplier(Supplier supplier) {
        this.supplier = supplier;
        return this;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return Objects.equals(name, part.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
