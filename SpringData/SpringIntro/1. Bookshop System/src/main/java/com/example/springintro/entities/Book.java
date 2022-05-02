package com.example.springintro.entities;

import com.example.springintro.entities.enums.AgeRestriction;
import com.example.springintro.entities.enums.EditionType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
@Entity
@Table(name = "books")
public class Book extends BaseEntity {
    @Column(nullable = false, length = 50)
    private String title;

    @Column(length = 1000)
    private String description;
    @Enumerated()
    private EditionType editionType;
    @Column(precision = 19, scale = 2, nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Integer copies;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Enumerated
    private AgeRestriction ageRestriction;
    @ManyToOne
    private Author author;
    @ManyToMany
    private Set<Category> categories;

    @Autowired
    public Book() {

    }

   public Book(String title, EditionType editionType, BigDecimal price, LocalDate releaseDate,
               AgeRestriction ageRestriction, Author author, Set<Category>categories, Integer copies){
        this.title = title;
        this.editionType = editionType;
        this.price = price;
        this.releaseDate = releaseDate;
        this.ageRestriction = ageRestriction;
        this.author = author;
        this.categories = categories;
        this.copies = copies;
   }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EditionType getEditionType() {
        return editionType;
    }

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
