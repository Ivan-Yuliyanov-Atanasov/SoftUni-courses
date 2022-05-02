package softuni.exam.models.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{

    @Column(unique = true)
    private String name;

    @Column(name = "date_and_time")
    private LocalDateTime dateAndTime;


    @ManyToOne(optional = false)
    private Car car;

    public String getName() {
        return name;
    }

    public Picture setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public Picture setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
        return this;
    }

    public Car getCar() {
        return car;
    }

    public Picture setCar(Car car) {
        this.car = car;
        return this;
    }
}
