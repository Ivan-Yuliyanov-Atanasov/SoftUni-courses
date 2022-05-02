package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarId {

    @XmlElement
    private Long id;

    public CarId() {
    }

    public Long getId() {
        return id;
    }

    public CarId setId(Long id) {
        this.id = id;
        return this;
    }
}
