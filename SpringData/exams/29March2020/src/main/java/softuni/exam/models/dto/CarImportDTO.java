package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


public class CarImportDTO {

    @Expose
    @Size(min = 2, max = 19)
    @NotBlank
    private String make;
    @Expose
    @Size(min = 2, max = 19)
    @NotBlank
    private String model;
    @Expose
    @Positive
    @NotNull
    private Integer kilometers;
    @Expose
    @NotBlank
    private String registeredOn;

    public String getMake() {
        return make;
    }

    public CarImportDTO setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarImportDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public CarImportDTO setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
        return this;
    }

    public String getRegisteredOn() {
        return registeredOn;
    }

    public CarImportDTO setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
        return this;
    }
}
