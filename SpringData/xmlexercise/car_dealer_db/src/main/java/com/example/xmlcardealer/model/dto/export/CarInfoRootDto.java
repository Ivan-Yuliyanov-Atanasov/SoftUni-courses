package com.example.xmlcardealer.model.dto.export;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarInfoRootDto {

    @XmlElement(name = "car")
    private List<CarInfoDto> cars;

    public CarInfoRootDto() {
    }

    public List<CarInfoDto> getCars() {
        return cars;
    }

    public CarInfoRootDto setCars(List<CarInfoDto> cars) {
        this.cars = cars;
        return this;
    }
}
