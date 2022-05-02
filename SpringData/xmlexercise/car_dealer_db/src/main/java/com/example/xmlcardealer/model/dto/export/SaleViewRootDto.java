package com.example.xmlcardealer.model.dto.export;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleViewRootDto {

    @XmlElement(name = "sale")
    private List<SaleViewDto> sales;

    public SaleViewRootDto() {
    }

    public List<SaleViewDto> getSales() {
        return sales;
    }

    public SaleViewRootDto setSales(List<SaleViewDto> sales) {
        this.sales = sales;
        return this;
    }
}
