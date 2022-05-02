package com.example.xmlcardealer.model.dto.importData;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerSeedDto {

    @XmlAttribute
    private String name;
    @XmlElement(name = "birth-date")
    private String birthDate;
    @XmlElement(name = "is-young-driver")
    private boolean isYoungDriver;

    public CustomerSeedDto() {
    }

    public String getName() {
        return name;
    }

    public CustomerSeedDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public CustomerSeedDto setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public CustomerSeedDto setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
        return this;
    }
}
