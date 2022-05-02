package softuni.exam.domain.dtos;

import com.google.gson.annotations.Expose;
import softuni.exam.domain.entities.enums.PositionEnum;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.math.BigDecimal;

public class PlayerSeedDto {

    @Expose
    @NotNull
    private String firstName;

    @Expose
    @NotNull
    @Size(min = 3, max = 15)
    private String lastName;

    @Expose
    @NotNull
    @Min(value = 1)
    @Max(value = 99)
    private Integer number;

    @Expose
    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal salary;

    @Expose
    @NotNull
    private PositionEnum position;

    @NotNull
    @Expose
    private TeamSeedDto team;

    @NotNull
    @Expose
    private PictureSeedDto picture;

    public PlayerSeedDto() {
    }

    public PictureSeedDto getPicture() {
        return picture;
    }

    public PlayerSeedDto setPicture(PictureSeedDto picture) {
        this.picture = picture;
        return this;
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

    public Integer getNumber() {
        return number;
    }

    public PlayerSeedDto setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public PlayerSeedDto setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public PositionEnum getPosition() {
        return position;
    }

    public PlayerSeedDto setPosition(PositionEnum position) {
        this.position = position;
        return this;
    }

    public TeamSeedDto getTeam() {
        return team;
    }

    public PlayerSeedDto setTeam(TeamSeedDto team) {
        this.team = team;
        return this;
    }
}
