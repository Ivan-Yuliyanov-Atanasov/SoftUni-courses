package com.example.jsoncardealer.repository;

import com.example.jsoncardealer.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByMakeOrderByModelAscTravelledDistanceDesc(String make);
}
