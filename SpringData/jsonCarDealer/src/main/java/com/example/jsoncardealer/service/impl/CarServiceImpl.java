package com.example.jsoncardealer.service.impl;

import com.example.jsoncardealer.model.dto.*;
import com.example.jsoncardealer.model.entity.Car;

import com.example.jsoncardealer.repository.CarRepository;
import com.example.jsoncardealer.service.CarService;
import com.example.jsoncardealer.service.PartService;
import com.example.jsoncardealer.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final PartService parService;
    public static final String CARS_FILE_PATH = "src/main/resources/files/cars.json";
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CarServiceImpl(CarRepository carRepository, PartService parService, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.carRepository = carRepository;
        this.parService = parService;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCars() throws IOException {
        if (carRepository.count() > 0) {
            return;
        }

        String categoryFileContent = Files.readString(Path.of(CARS_FILE_PATH));

        CarSeedDto[] carSeedDtos = gson.fromJson(categoryFileContent, CarSeedDto[].class);
        Arrays.stream(carSeedDtos).filter(validationUtil::isValid).
                map(carSeedDto -> {
                    Car car = modelMapper.map(carSeedDto, Car.class);
                    car.setParts(parService.findRandomParts());
                    return car;
                })

                .forEach(carRepository::save);
    }

    @Override
    public Car findRandomCar() {
        long randomId = ThreadLocalRandom.current().nextLong(1, carRepository.count() + 1);
        return carRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<CarViewDto> carsByMake(String make) {

        return carRepository.findByMakeOrderByModelAscTravelledDistanceDesc(make).stream()
                .map(car -> modelMapper.map(car, CarViewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarWithPartsViewDto> getAllCars() {
        return carRepository.findAll().stream()
                .map(car -> {
                    CarWithPartsViewDto carWithPartsViewDto = modelMapper.map(car, CarWithPartsViewDto.class);
                    Set<PartViewDto> partViewDtoSet = car.getParts().stream().map(part -> modelMapper.map(part, PartViewDto.class))
                            .collect(Collectors.toSet());
                    carWithPartsViewDto.setParts(partViewDtoSet);
                    return carWithPartsViewDto;
                }).collect(Collectors.toList());
    }
}
