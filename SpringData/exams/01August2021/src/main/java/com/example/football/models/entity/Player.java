package com.example.football.models.entity;


import com.example.football.models.entity.enums.PositionEnum;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "players")
public class Player extends BaseEntity{

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Enumerated
    @Column(nullable = false)
    private PositionEnum position;

    @ManyToOne
    private Town town;

    @ManyToOne
    private Team team;

    @ManyToOne
    private Stat stat;

    public Player() {
    }

    public String getFirstName() {
        return firstName;
    }

    public Player setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Player setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Player setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Player setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public PositionEnum getPosition() {
        return position;
    }

    public Player setPosition(PositionEnum position) {
        this.position = position;
        return this;
    }

    public Town getTown() {
        return town;
    }

    public Player setTown(Town town) {
        this.town = town;
        return this;
    }

    public Team getTeam() {
        return team;
    }

    public Player setTeam(Team team) {
        this.team = team;
        return this;
    }

    public Stat getStat() {
        return stat;
    }

    public Player setStat(Stat stat) {
        this.stat = stat;
        return this;
    }
}
