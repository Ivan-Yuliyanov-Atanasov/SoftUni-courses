package com.example.shop_db.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoldProductDto {

    @XmlElement(name = "product")
    private List<ProductViewDto> soldProducts;

    public SoldProductDto() {
    }

    public List<ProductViewDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductViewDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
