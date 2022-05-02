package com.example.xmlcardealer.model.dto.export;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarViewRootDto {

    @XmlElement(name = "car")
    private List<CarViewDto> cars;

    public CarViewRootDto() {
    }

    public List<CarViewDto> getCars() {
        return cars;
    }

    public CarViewRootDto setCars(List<CarViewDto> cars) {
        this.cars = cars;
        return this;
    }
}
