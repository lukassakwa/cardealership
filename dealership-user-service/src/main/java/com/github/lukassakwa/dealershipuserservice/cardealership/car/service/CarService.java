package com.github.lukassakwa.dealershipuserservice.cardealership.car.service;

import com.github.lukassakwa.dealershipuserservice.cardealership.car.domain.Car;
import com.github.lukassakwa.dealershipuserservice.cardealership.car.repo.CarRepository;
import com.github.lukassakwa.dealershipuserservice.cardealership.dealership.domain.Dealership;
import com.github.lukassakwa.dealershipuserservice.mappers.CarMapper;
import com.github.lukassakwa.dealershipuserservice.resources.dto.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper mapper;

    public List<CarDto> getAllCars() {
        return carRepository.getAllBy().stream()
                .map(mapper::toFullDto)
                .collect(Collectors.toList());
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    //Todo: change Exception
    public Car findById(Long carId) {
        return carRepository.findById(carId)
                .orElseThrow(() -> { throw new IllegalStateException("Car does not exist"); });
    }

}
