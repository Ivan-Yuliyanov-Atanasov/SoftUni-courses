package com.example.football.models.dto;

import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.models.entity.enums.PositionEnum;
import com.google.gson.annotations.Expose;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerSeedDto {


    @NotNull
    @XmlElement(name = "first-name")
    @Size(min = 2)
    private String firstName;


    @NotNull
    @XmlElement(name = "last-name")
    @Size(min = 2)
    private String lastName;


    @NotNull
    @XmlElement
    @Email
    private String email;


    @NotNull
    @XmlElement(name = "birth-date")
    private String birthDate;


    @NotNull
    @XmlElement
    private PositionEnum position;

    @XmlElement
    private TownImportDTO town;

    @XmlElement
    private TownImportDTO team;

    @XmlElement
    private StatSeedDTO stat;

    public PlayerSeedDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public PlayerSeedDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PlayerSeedDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PlayerSeedDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public PlayerSeedDto setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public PositionEnum getPosition() {
        return position;
    }

    public PlayerSeedDto setPosition(PositionEnum position) {
        this.position = position;
        return this;
    }

    public TownImportDTO getTown() {
        return town;
    }

    public PlayerSeedDto setTown(TownImportDTO town) {
        this.town = town;
        return this;
    }

    public TownImportDTO getTeam() {
        return team;
    }

    public PlayerSeedDto setTeam(TownImportDTO team) {
        this.team = team;
        return this;
    }

    public StatSeedDTO getStat() {
        return stat;
    }

    public PlayerSeedDto setStat(StatSeedDTO stat) {
        this.stat = stat;
        return this;
    }
}
