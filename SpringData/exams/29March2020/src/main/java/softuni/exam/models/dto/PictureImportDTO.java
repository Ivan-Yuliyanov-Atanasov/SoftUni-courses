package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class PictureImportDTO {

    @Expose
    @Size(min = 2, max = 19)
    @NotBlank
    private String name;
    @Expose
    @NotBlank
    private String dateAndTime;

    @Expose
    @Positive
    @NotNull
    private Long car;

    public String getName() {
        return name;
    }

    public PictureImportDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public PictureImportDTO setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
        return this;
    }

    public Long getCar() {
        return car;
    }

    public PictureImportDTO setCar(Long car) {
        this.car = car;
        return this;
    }
}
