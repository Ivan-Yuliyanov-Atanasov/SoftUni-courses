package exam.model.entity;


import exam.model.entity.enums.WarrantyType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "laptops")
public class Laptop extends BaseEntity{

    @Column(name = "mac_address", unique = true, nullable = false)
    private String macAddress;

    @Column(name = "cpu_speed", nullable = false)
    private Double cpuSpeed;

    @Column(nullable = false)
    private Integer ram;

    @Column(nullable = false)
    private Integer storage;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name =  "warranty_type", nullable = false)
    @Enumerated
    private WarrantyType warrantyType;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private Shop shop;

    public Laptop() {
    }

    public String getMacAddress() {
        return macAddress;
    }

    public Laptop setMacAddress(String macAddress) {
        this.macAddress = macAddress;
        return this;
    }

    public Double getCpuSpeed() {
        return cpuSpeed;
    }

    public Laptop setCpuSpeed(Double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
        return this;
    }

    public Integer getRam() {
        return ram;
    }

    public Laptop setRam(Integer ram) {
        this.ram = ram;
        return this;
    }

    public Integer getStorage() {
        return storage;
    }

    public Laptop setStorage(Integer storage) {
        this.storage = storage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Laptop setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Laptop setDescription(String description) {
        this.description = description;
        return this;
    }

    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public Laptop setWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
        return this;
    }

    public Shop getShop() {
        return shop;
    }

    public Laptop setShop(Shop shop) {
        this.shop = shop;
        return this;
    }
}
