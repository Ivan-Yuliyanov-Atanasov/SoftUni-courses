package com.example.shop_db.model.dto.task4;



import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoldProductDtoTask4 {
    @XmlAttribute(name = "count")
    private Integer count;

    @XmlElement(name = "product")
    private List<ProductViewDtoTask4> soldProducts;

    public SoldProductDtoTask4() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ProductViewDtoTask4> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductViewDtoTask4> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
