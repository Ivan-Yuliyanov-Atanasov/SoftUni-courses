package softuni.exam.models.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    private String make;
    private String model;
    private Integer kilometers;
    @Column(name = "registered_on")
    private LocalDate registeredOn;
    @OneToMany(mappedBy = "car")
    private Set<Picture> pictures;

    public String getMake() {
        return make;
    }

    public Car setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public Car setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
        return this;
    }

    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public Car setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public Car setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }
}
