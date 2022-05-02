package com.example.football.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "town")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownImportDTO {

    @Expose
    @XmlElement
    @Size(min = 2)
    @NotNull
    private String name;

    @Expose
    @Min(1)
    @NotNull
    private Integer population;

    @Expose
    @Size(min = 10)
    @NotNull
    private String travelGuide;

    public TownImportDTO() {
    }

    public String getName() {
        return name;
    }

    public TownImportDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPopulation() {
        return population;
    }

    public TownImportDTO setPopulation(Integer population) {
        this.population = population;
        return this;
    }

    public String getTravelGuide() {
        return travelGuide;
    }

    public TownImportDTO setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
        return this;
    }
}
