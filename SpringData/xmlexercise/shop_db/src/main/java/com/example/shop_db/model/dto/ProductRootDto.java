package com.example.shop_db.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductRootDto {
    @XmlElement(name = "product")
    List<ProductByNameAndPriceDto> products;

    public ProductRootDto() {
    }

    public List<ProductByNameAndPriceDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductByNameAndPriceDto> products) {
        this.products = products;
    }
}
