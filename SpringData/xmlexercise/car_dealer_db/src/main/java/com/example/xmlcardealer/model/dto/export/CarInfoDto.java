package com.example.xmlcardealer.model.dto.export;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarInfoDto {

    @XmlAttribute
    private String make;
    @XmlAttribute
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private Long travelledDistance;
    @XmlElement
    private PartViewRootDto parts;

    public CarInfoDto() {
    }

    public String getMake() {
        return make;
    }

    public CarInfoDto setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarInfoDto setModel(String model) {
        this.model = model;
        return this;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public CarInfoDto setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
        return this;
    }

    public PartViewRootDto getParts() {
        return parts;
    }

    public CarInfoDto setParts(PartViewRootDto parts) {
        this.parts = parts;
        return this;
    }
}
