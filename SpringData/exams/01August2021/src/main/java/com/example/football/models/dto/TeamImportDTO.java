package com.example.football.models.dto;


import com.google.gson.annotations.Expose;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "team")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamImportDTO {

    @Expose
    @XmlElement
    @Size(min = 3)
    @NotNull
    private String name;

    @Expose
    @Size(min = 3)
    @NotNull
    private String stadiumName;

    @Expose
    @Min(1000)
    @NotNull
    private Integer fanBase;

    @Expose
    @Size(min = 10)
    @NotNull
    private String history;

    @Expose
    private String townName;

    public TeamImportDTO() {
    }

    public TeamImportDTO(String name, String stadiumName, Integer fanBase, String history, String townName) {
        this.name = name;
        this.stadiumName = stadiumName;
        this.fanBase = fanBase;
        this.history = history;
        this.townName = townName;
    }

    public String getName() {
        return name;
    }

    public TeamImportDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public TeamImportDTO setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
        return this;
    }

    public Integer getFanBase() {
        return fanBase;
    }

    public TeamImportDTO setFanBase(Integer fanBase) {
        this.fanBase = fanBase;
        return this;
    }

    public String getHistory() {
        return history;
    }

    public TeamImportDTO setHistory(String history) {
        this.history = history;
        return this;
    }

    public String getTownName() {
        return townName;
    }

    public TeamImportDTO setTownName(String townName) {
        this.townName = townName;
        return this;
    }
}
