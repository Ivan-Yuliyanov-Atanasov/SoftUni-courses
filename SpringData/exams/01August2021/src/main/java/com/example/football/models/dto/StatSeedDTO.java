package com.example.football.models.dto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "stat")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatSeedDTO {


    @XmlElement
    private Long id;
    @XmlElement
    @Min(1)
    @NotNull
    private Float shooting;
    @XmlElement
    @Min(1)
    @NotNull
    private Float passing;
    @XmlElement
    @Min(1)
    @NotNull
    private Float endurance;

    public StatSeedDTO() {

    }

    public Float getShooting() {
        return shooting;
    }

    public StatSeedDTO setShooting(Float shooting) {
        this.shooting = shooting;
        return this;
    }

    public Float getPassing() {
        return passing;
    }

    public StatSeedDTO setPassing(Float passing) {
        this.passing = passing;
        return this;
    }

    public Float getEndurance() {
        return endurance;
    }

    public StatSeedDTO setEndurance(Float endurance) {
        this.endurance = endurance;
        return this;
    }

    public Long getId() {
        return id;
    }

    public StatSeedDTO setId(Long id) {
        this.id = id;
        return this;
    }
}
