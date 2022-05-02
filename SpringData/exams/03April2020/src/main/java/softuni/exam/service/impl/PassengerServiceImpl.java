package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PassengerImportDTO;
import softuni.exam.models.dto.TownImportDTO;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


@Service
public class PassengerServiceImpl implements PassengerService {

    public static final String PASSENGERS_FILE_PATH = "src/main/resources/files/json/passengers.json";

    private final PassengerRepository passengerRepository;
    private final TownService townService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public PassengerServiceImpl(PassengerRepository passengerRepository, TownService townService, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.passengerRepository = passengerRepository;
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.passengerRepository.count() > 1;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(Path.of(PASSENGERS_FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {
        StringBuilder sb = new StringBuilder();

        PassengerImportDTO[] passengers = gson.fromJson(new FileReader(PASSENGERS_FILE_PATH), PassengerImportDTO[].class);

        Arrays.stream(passengers)
                .forEach(passengerImportDTO -> {
                    if (!validationUtil.isValid(passengerImportDTO)) {
                        sb.append("Invalid Passenger");

                    } else {
                        Town town = townService.findTownByName(passengerImportDTO.getTown());

                        this.passengerRepository.save(modelMapper.map(passengerImportDTO, Passenger.class).setTown(town));
                        sb.append(String.format("Successfully imported Passenger %s - %s",passengerImportDTO.getLastName(), passengerImportDTO.getEmail()));


                    }

                    sb.append(System.lineSeparator());
                });


        return sb.toString().trim();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        StringBuilder sb = new StringBuilder();

        this.passengerRepository.exportPassengers()
                .forEach(passenger -> {
                    sb.append(String.format("Passenger %s  %s\n" +
                            "Email - %s\n" +
                            "Phone - %s\n" +
                            "Number of tickets - %d\n\n",passenger.getFirstName(), passenger.getLastName(), passenger.getEmail(), passenger.getPhoneNumber(), passenger.getTickets().size()));
                });

        return sb.toString().trim();
    }

    @Override
    public Passenger findPassengerByEmail(String email) {
        return this.passengerRepository.findByEmail(email);
    }
}
