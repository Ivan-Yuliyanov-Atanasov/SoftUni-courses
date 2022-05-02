package com.example.xmlcardealer.model.dto.export;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerViewDto {
    @XmlElement
    private Long id;
    @XmlElement
    private String name;
    @XmlElement(name = "birth-date")
    private String birthDate;
    @XmlElement(name = "is-young-driver")
    private boolean isYoungDriver;


    public CustomerViewDto() {

    }

    public Long getId() {
        return id;
    }

    public CustomerViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CustomerViewDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public CustomerViewDto setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public CustomerViewDto setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
        return this;
    }


}
