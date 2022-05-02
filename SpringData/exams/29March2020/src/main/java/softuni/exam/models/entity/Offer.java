package softuni.exam.models.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    private BigDecimal price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "has_gold_status")
    private boolean hasGoldStatus;

    @Column(name = "added_on")
    private LocalDateTime addedOn;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Seller seller;

    @ManyToMany
    private Set<Picture> pictures;

    public BigDecimal getPrice() {
        return price;
    }

    public Offer setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean isHasGoldStatus() {
        return hasGoldStatus;
    }

    public Offer setHasGoldStatus(boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
        return this;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public Offer setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    public Car getCar() {
        return car;
    }

    public Offer setCar(Car car) {
        this.car = car;
        return this;
    }

    public Seller getSeller() {
        return seller;
    }

    public Offer setSeller(Seller seller) {
        this.seller = seller;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public Offer setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }
}
