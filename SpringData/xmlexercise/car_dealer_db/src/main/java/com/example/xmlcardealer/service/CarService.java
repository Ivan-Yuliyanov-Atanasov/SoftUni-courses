package com.example.xmlcardealer.service;


import com.example.xmlcardealer.model.dto.export.CarInfoRootDto;
import com.example.xmlcardealer.model.dto.export.CarViewRootDto;
import com.example.xmlcardealer.model.dto.importData.CarSeedDto;
import com.example.xmlcardealer.model.entity.Car;

import java.util.List;

public interface CarService {

    void seedCars(List<CarSeedDto> cars);

    Car findRandomCar();

    CarViewRootDto carsByMake(String make);

    CarInfoRootDto getAllCars();
}
