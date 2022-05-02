package softuni.exam.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "planes")
public class Plane extends BaseEntity{

    @Column(nullable = false)
    private String airline;

    @Column(nullable = false)
    private Integer capacity;

    @Column(name = "register_number", unique = true, nullable = false)
    private String registerNumber;

    public String getAirline() {
        return airline;
    }

    public Plane setAirline(String airline) {
        this.airline = airline;
        return this;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Plane setCapacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public Plane setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
        return this;
    }
}
