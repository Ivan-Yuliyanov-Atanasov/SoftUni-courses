package com.example.xmlcardealer.model.dto.export;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;


@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleViewDto {
    @XmlElement
    private CarViewNoIdDto car;

    @XmlElement(name = "customer-name")
    private String customerName;
    @XmlElement
    private Double discount;
    @XmlElement
    private BigDecimal price;
    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;

    public SaleViewDto() {
    }

    public CarViewNoIdDto getCar() {
        return car;
    }

    public SaleViewDto setCar(CarViewNoIdDto car) {
        this.car = car;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public SaleViewDto setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public Double getDiscount() {
        return discount;
    }

    public SaleViewDto setDiscount(Double discount) {
        this.discount = discount;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public SaleViewDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public SaleViewDto setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
        return this;
    }
}
