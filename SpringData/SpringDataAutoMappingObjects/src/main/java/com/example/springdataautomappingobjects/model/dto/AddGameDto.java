package com.example.springdataautomappingobjects.model.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AddGameDto {

    @Length(min = 3, max = 100, message = "Title length should be between 3 and 100 symbols.")
    @Pattern(regexp = "[A-Z]+.+", message = "Invalid title")
    private String title;
    @DecimalMin(value = "0", message = "Price should be positive number.")
    private BigDecimal price;
    @Min(value = 0, message = "Size should be positive number.")
    private Double size;
    @Length(min = 11, max = 11, message = "Not valid YouTube URL.")
    private String trailer;
    @Pattern(regexp = "(https?).+", message = "Thumbnail URL is not valid.")
    private String thumbnailUrl;
    @Length(min = 20, message = "Must be at least 20 symbols.")
    private String description;
    private LocalDate releaseDate;

    public AddGameDto() {
    }

    public AddGameDto(String title, BigDecimal price, Double size, String trailer, String thumbnailUrl, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.thumbnailUrl = thumbnailUrl;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
