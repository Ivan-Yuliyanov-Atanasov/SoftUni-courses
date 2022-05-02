package com.example.jsoncardealer.service;

import com.example.jsoncardealer.model.dto.CarViewDto;
import com.example.jsoncardealer.model.dto.CarWithPartsViewDto;
import com.example.jsoncardealer.model.entity.Car;

import java.io.IOException;
import java.util.List;

public interface CarService {

    void seedCars() throws IOException;

    Car findRandomCar();

    List<CarViewDto> carsByMake(String make);

    List<CarWithPartsViewDto> getAllCars();
}
