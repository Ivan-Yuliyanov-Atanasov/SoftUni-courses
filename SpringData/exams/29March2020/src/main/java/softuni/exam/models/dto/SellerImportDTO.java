package softuni.exam.models.dto;

import softuni.exam.models.entity.enums.Rating;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "seller")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerImportDTO {

    @XmlElement(name = "first-name")
    @Size(min = 2, max = 19)
    @NotBlank
    private String firstName;

    @XmlElement(name = "last-name")
    @Size(min = 2, max = 19)
    @NotBlank
    private String lastName;

    @XmlElement()
    @Email
    private String email;


    @NotNull
    @XmlElement
    private Rating rating;

    @NotNull
    @XmlElement
    private String town;

    public String getFirstName() {
        return firstName;
    }

    public SellerImportDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SellerImportDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SellerImportDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public Rating getRating() {
        return rating;
    }

    public SellerImportDTO setRating(Rating rating) {
        this.rating = rating;
        return this;
    }

    public String getTown() {
        return town;
    }

    public SellerImportDTO setTown(String town) {
        this.town = town;
        return this;
    }
}
