package softuni.exam.models.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity{

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false, unique = true)
    private String serialNumber;

    @Column(name = "take_off", nullable = false)
    private LocalDateTime takeOff;

    @ManyToOne
    @NotNull
    private Town fromTown;

    @ManyToOne
    @NotNull
    private Town toTown;

    @ManyToOne
    @NotNull
    private Passenger passenger;

    @ManyToOne
    @NotNull
    private Plane plane;

    public BigDecimal getPrice() {
        return price;
    }

    public Ticket setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Ticket setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public LocalDateTime getTakeOff() {
        return takeOff;
    }

    public Ticket setTakeOff(LocalDateTime takeOff) {
        this.takeOff = takeOff;
        return this;
    }

    public Town getFromTown() {
        return fromTown;
    }

    public Ticket setFromTown(Town fromTown) {
        this.fromTown = fromTown;
        return this;
    }

    public Town getToTown() {
        return toTown;
    }

    public Ticket setToTown(Town toTown) {
        this.toTown = toTown;
        return this;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Ticket setPassenger(Passenger passenger) {
        this.passenger = passenger;
        return this;
    }

    public Plane getPlane() {
        return plane;
    }

    public Ticket setPlane(Plane plane) {
        this.plane = plane;
        return this;
    }
}
