package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarImportDTO;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class CarServiceImpl implements CarService {

    private static final String CARS_FILE_PATH = "src/main/resources/files/json/cars.json";

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder sb = new StringBuilder();

        CarImportDTO[] cars = gson.fromJson(readCarsFileContent(), CarImportDTO[].class);

        System.out.println();
        Arrays.stream(cars).forEach(car -> {
            if (!validationUtil.isValid(car)){
                sb.append("Invalid car");
            } else {
                this.carRepository.save(modelMapper.map(car, Car.class));
                sb.append(String.format("Successfully imported car - %s - %s",car.getMake(), car.getModel()));

            }
            sb.append(System.lineSeparator());
        });
        return sb.toString().trim();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        StringBuilder sb = new StringBuilder();
        this.carRepository.exportCars().forEach(sb::append);
        return sb.toString().trim();
    }

    @Override
    public Car findById(Long id) {
        return this.carRepository.findById(id).orElse(null);
    }
}
