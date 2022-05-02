package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String name;

    @Column(name = "stadium_name", nullable = false)
    private String stadiumName;

    @Column(name = "fan_base", nullable = false)
    private Integer fanBase;

    @Column(name = "history", columnDefinition = "TEXT", nullable = false)
    private String history;

    @ManyToOne
    private Town town;

    public Team() {
    }

    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public Team setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
        return this;
    }

    public Integer getFanBase() {
        return fanBase;
    }

    public Team setFanBase(Integer fanBase) {
        this.fanBase = fanBase;
        return this;
    }

    public String getHistory() {
        return history;
    }

    public Team setHistory(String history) {
        this.history = history;
        return this;
    }

    public Town getTown() {
        return town;
    }

    public Team setTown(Town town) {
        this.town = town;
        return this;
    }
}
