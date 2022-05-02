package com.example.xmlcardealer.model.dto.export;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerSpentMoneyRootDto {

    @XmlElement
    private List<CustomerSpentMoneyDto> customers;

    public CustomerSpentMoneyRootDto() {
    }

    public List<CustomerSpentMoneyDto> getCustomers() {
        return customers;
    }

    public CustomerSpentMoneyRootDto setCustomers(List<CustomerSpentMoneyDto> customers) {
        this.customers = customers;
        return this;
    }
}
