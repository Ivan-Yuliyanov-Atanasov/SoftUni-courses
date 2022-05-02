package exam.model.entity;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "shops")
public class Shop extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal income;

    @Column(nullable = false)
    private String address;

    @Column(name = "employee_count", nullable = false)
    private Integer employeeCount;

    @Column(name = "shop_area", nullable = false)
    private Integer shopArea;

   @ManyToOne
    @Fetch(FetchMode.JOIN)
    private Town town;

    public Shop() {
    }

    public String getName() {
        return name;
    }

    public Shop setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public Shop setIncome(BigDecimal income) {
        this.income = income;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Shop setAddress(String address) {
        this.address = address;
        return this;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public Shop setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
        return this;
    }

    public Integer getShopArea() {
        return shopArea;
    }

    public Shop setShopArea(Integer shopArea) {
        this.shopArea = shopArea;
        return this;
    }

    public Town getTown() {
        return town;
    }

    public Shop setTown(Town town) {
        this.town = town;
        return this;
    }
}
