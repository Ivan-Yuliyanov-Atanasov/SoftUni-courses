package com.example.xmlcardealer.model.dto.export;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerViewRootDto {

    @XmlElement(name = "customer")
    private List<CustomerViewDto> customers;

    public CustomerViewRootDto() {
    }

    public List<CustomerViewDto> getCustomers() {
        return customers;
    }

    public CustomerViewRootDto setCustomers(List<CustomerViewDto> customers) {
        this.customers = customers;
        return this;
    }
}
