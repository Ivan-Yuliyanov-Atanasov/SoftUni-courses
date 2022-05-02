package softuni.exam.models.dto;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;


@XmlRootElement(name = "ticket")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketImportDTO {

    @XmlElement
    @NotNull
    @DecimalMin("1")
    private BigDecimal price;

    @XmlElement(name = "serial-number")
    @NotNull
    @Size(min = 2)
    private String serialNumber;

    @XmlElement(name = "take-off")
    @NotNull
    private String takeOff;

    @XmlElement(name = "from-town")
    @NotNull
    private TownImportDTO fromTown;

    @XmlElement(name = "to-town")
    @NotNull
    private TownImportDTO toTown;

    @XmlElement
    @NotNull
    private PassengerImportDTO passenger;

    @XmlElement
    @NotNull
    private PlaneImportDTO plane;

    public BigDecimal getPrice() {
        return price;
    }

    public TicketImportDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public TicketImportDTO setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public String getTakeOff() {
        return takeOff;
    }

    public TicketImportDTO setTakeOff(String takeOff) {
        this.takeOff = takeOff;
        return this;
    }

    public TownImportDTO getFromTown() {
        return fromTown;
    }

    public TicketImportDTO setFromTown(TownImportDTO fromTown) {
        this.fromTown = fromTown;
        return this;
    }

    public TownImportDTO getToTown() {
        return toTown;
    }

    public TicketImportDTO setToTown(TownImportDTO toTown) {
        this.toTown = toTown;
        return this;
    }

    public PassengerImportDTO getPassenger() {
        return passenger;
    }

    public TicketImportDTO setPassenger(PassengerImportDTO passenger) {
        this.passenger = passenger;
        return this;
    }

    public PlaneImportDTO getPlane() {
        return plane;
    }

    public TicketImportDTO setPlane(PlaneImportDTO plane) {
        this.plane = plane;
        return this;
    }
}
