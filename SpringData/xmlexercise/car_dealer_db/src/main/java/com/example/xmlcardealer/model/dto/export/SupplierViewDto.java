package com.example.xmlcardealer.model.dto.export;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierViewDto {

    @XmlAttribute
    private Long id;
    @XmlAttribute
    private String name;
    @XmlAttribute(name = "parts-count")
    private Integer partsCount;

    public SupplierViewDto() {
    }

    public Long getId() {
        return id;
    }

    public SupplierViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SupplierViewDto setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPartsCount() {
        return partsCount;
    }

    public SupplierViewDto setPartsCount(Integer partsCount) {
        this.partsCount = partsCount;
        return this;
    }
}
