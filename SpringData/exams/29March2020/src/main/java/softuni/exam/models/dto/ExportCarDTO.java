package softuni.exam.models.dto;


import java.time.LocalDate;

public class ExportCarDTO {

    private String make;
    private String model;
    private Integer kilometers;
    private LocalDate registeredOn;
    private Integer numberOfPictures;

    public ExportCarDTO(String make, String model, Integer kilometers, LocalDate registeredOn, Integer numberOfPictures) {
        this.make = make;
        this.model = model;
        this.kilometers = kilometers;
        this.registeredOn = registeredOn;
        this.numberOfPictures = numberOfPictures;
    }

    @Override
    public String toString() {
        return String.format("Car make - %s, model - %s\n" +
                "\tKilometers - %d\n" +
                "\tRegistered on - %s\n" +
                "\tNumber of pictures - %d\n\n",this.make, this.model, this.kilometers, this.registeredOn, this.numberOfPictures);
    }
}
