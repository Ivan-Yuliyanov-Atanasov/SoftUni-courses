package softuni.exam.models.entity;


import softuni.exam.models.entity.enums.Rating;

import javax.persistence.*;

@Entity
@Table(name = "sellers")
public class Seller extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String email;


    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Column(nullable = false)
    private String town;

    public String getFirstName() {
        return firstName;
    }

    public Seller setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Seller setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Seller setEmail(String email) {
        this.email = email;
        return this;
    }

    public Rating getRating() {
        return rating;
    }

    public Seller setRating(Rating rating) {
        this.rating = rating;
        return this;
    }

    public String getTown() {
        return town;
    }

    public Seller setTown(String town) {
        this.town = town;
        return this;
    }
}
