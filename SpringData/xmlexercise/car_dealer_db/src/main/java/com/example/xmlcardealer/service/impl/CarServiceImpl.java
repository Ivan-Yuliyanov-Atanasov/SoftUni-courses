package com.example.xmlcardealer.service.impl;

import com.example.xmlcardealer.model.dto.export.*;
import com.example.xmlcardealer.model.dto.importData.CarSeedDto;

import com.example.xmlcardealer.model.entity.Car;
import com.example.xmlcardealer.repository.CarRepository;
import com.example.xmlcardealer.service.CarService;
import com.example.xmlcardealer.service.PartService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final PartService partService;
    private final ModelMapper modelMapper;

    public CarServiceImpl(CarRepository carRepository, PartService partService, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.partService = partService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCars(List<CarSeedDto> cars) {
        if (carRepository.count() > 0) {
            return;
        }
        cars.
                stream()
                .map(carSeedDto -> {
                    Car car = modelMapper.map(carSeedDto, Car.class);
                    car.setParts(partService.findRandomParts());
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
    public CarViewRootDto carsByMake(String make) {
        List<CarViewDto> cars = carRepository.findByMakeOrderByModelAscTravelledDistanceDesc(make)
                .stream()
                .map(car -> modelMapper.map(car, CarViewDto.class))
                .collect(Collectors.toList());

        return new CarViewRootDto().setCars(cars);
    }

    @Override
    public CarInfoRootDto getAllCars() {

        List<CarInfoDto> cars = carRepository.findAll()
                .stream()
                .map(car -> {
                    CarInfoDto carInfoDto = modelMapper.map(car, CarInfoDto.class);
                    List<PartViewDto> parts = car.getParts().stream()
                            .map(part -> modelMapper.map(part, PartViewDto.class))
                            .collect(Collectors.toList());
                    PartViewRootDto partViewRootDto = new PartViewRootDto().setParts(parts);
                    carInfoDto.setParts(partViewRootDto);
                    return carInfoDto;
                }).collect(Collectors.toList());


        return new CarInfoRootDto().setCars(cars);
    }
}
