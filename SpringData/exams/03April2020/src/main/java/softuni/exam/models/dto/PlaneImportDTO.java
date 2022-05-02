package softuni.exam.models.dto;


import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "plane")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneImportDTO {

    @XmlElement
    @NotNull
    @Size(min = 2)
    private String airline;

    @XmlElement
    @NotNull
    @Positive
    private Integer capacity;

    @XmlElement(name = "register-number")
    @NotNull
    @Size(min = 5)
    private String registerNumber;

    public String getAirline() {
        return airline;
    }

    public PlaneImportDTO setAirline(String airline) {
        this.airline = airline;
        return this;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public PlaneImportDTO setCapacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public PlaneImportDTO setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
        return this;
    }
}
