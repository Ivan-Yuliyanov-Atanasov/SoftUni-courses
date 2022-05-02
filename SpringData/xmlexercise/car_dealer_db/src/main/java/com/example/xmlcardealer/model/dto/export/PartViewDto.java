package com.example.xmlcardealer.model.dto.export;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartViewDto {

    @XmlAttribute
    private String name;
    @XmlAttribute
    private BigDecimal price;

    public PartViewDto() {

    }

    public String getName() {
        return name;
    }

    public PartViewDto setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public PartViewDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
