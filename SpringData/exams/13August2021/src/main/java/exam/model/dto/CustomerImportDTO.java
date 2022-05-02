package exam.model.dto;

import com.google.gson.annotations.Expose;
import exam.model.entity.Town;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class CustomerImportDTO {

    @Expose
    @Size(min = 2)
    @NotNull
    private String firstName;

    @Expose
    @Size(min = 2)
    @NotNull
    private String lastName;

    @Expose
    @Email
    @NotNull
    private String email;

    @Expose
    @NotNull
    private String registeredOn;

    @Expose
    private TownImportDTO town;

    public CustomerImportDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public CustomerImportDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CustomerImportDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CustomerImportDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getRegisteredOn() {
        return registeredOn;
    }

    public CustomerImportDTO setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
        return this;
    }

    public TownImportDTO getTown() {
        return town;
    }

    public CustomerImportDTO setTown(TownImportDTO town) {
        this.town = town;
        return this;
    }
}
