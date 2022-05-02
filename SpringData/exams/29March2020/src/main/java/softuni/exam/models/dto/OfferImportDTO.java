package softuni.exam.models.dto;


import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;


@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferImportDTO {


    @XmlElement
    @Positive
    private BigDecimal price;

    @XmlElement
    @NotBlank
    @Size(min = 5)
    private String description;

    @XmlElement(name = "has-gold-status")
    private boolean hasGoldStatus;

    @XmlElement(name = "added-on")
    private String addedOn;
    @XmlElement(name = "car")
    private CarId car;
    @XmlElement(name = "seller")
    private SellerId seller;

    public BigDecimal getPrice() {
        return price;
    }

    public OfferImportDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferImportDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean isHasGoldStatus() {
        return hasGoldStatus;
    }

    public OfferImportDTO setHasGoldStatus(boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
        return this;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public OfferImportDTO setAddedOn(String addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    public CarId getCar() {
        return car;
    }

    public OfferImportDTO setCar(CarId car) {
        this.car = car;
        return this;
    }

    public SellerId getSeller() {
        return seller;
    }

    public OfferImportDTO setSeller(SellerId seller) {
        this.seller = seller;
        return this;
    }
}
