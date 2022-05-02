package com.example.xmlcardealer.model.dto.export;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerSpentMoneyDto {
    @XmlAttribute(name = "full-name")
    private String fullName;
    @XmlAttribute(name = "bought-cars")
    private Integer boughtCars;
    @XmlAttribute(name = "spent-money")
    private BigDecimal spentMoney;

    public CustomerSpentMoneyDto() {
    }

    public String getFullName() {
        return fullName;
    }

    public CustomerSpentMoneyDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Integer getBoughtCars() {
        return boughtCars;
    }

    public CustomerSpentMoneyDto setBoughtCars(Integer boughtCars) {
        this.boughtCars = boughtCars;
        return this;
    }

    public BigDecimal getSpentMoney() {
        return spentMoney;
    }

    public CustomerSpentMoneyDto setSpentMoney(BigDecimal spentMoney) {
        this.spentMoney = spentMoney;
        return this;
    }
}
