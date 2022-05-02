package exam.model.dto;


import com.google.gson.annotations.Expose;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "shop")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopImportDTO {

    @Expose
    @XmlElement
    @Size(min = 4)
    @NotNull
    private String name;

    @XmlElement
    @NotNull
    @DecimalMin("20000")
    private BigDecimal income;

    @XmlElement
    @NotNull
    @Size(min = 4)
    private String address;

    @XmlElement(name = "employee-count")
    @NotNull
    @Min(1)
    @Max(50)
    private Integer employeeCount;

    @XmlElement(name = "shop-area")
    @NotNull
    @Min(150)
    private Integer shopArea;

    @XmlElement(name = "town")
    private TownImportDTO town;

    public ShopImportDTO() {
    }

    public String getName() {
        return name;
    }

    public ShopImportDTO setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public ShopImportDTO setIncome(BigDecimal income) {
        this.income = income;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ShopImportDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public ShopImportDTO setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
        return this;
    }

    public Integer getShopArea() {
        return shopArea;
    }

    public ShopImportDTO setShopArea(Integer shopArea) {
        this.shopArea = shopArea;
        return this;
    }

    public TownImportDTO getTown() {
        return town;
    }

    public ShopImportDTO setTown(TownImportDTO town) {
        this.town = town;
        return this;
    }
}
