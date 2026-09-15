package com.example.louezvotrevoiture.fr.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.louezvotrevoiture.fr.entities.Car;
import com.example.louezvotrevoiture.fr.entities.CarRepository;
import com.example.louezvotrevoiture.fr.entities.Dates;

@RestController
public class CarRental {

    private CarRepository carRepository;
    private RentalServiceImpl rentalService;

    public CarRental(CarRepository carRepository, RentalServiceImpl rentalService) {
        this.carRepository = carRepository;
        this.rentalService = rentalService;
    }

    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Car> listOfCars() {

        return (List<Car>) carRepository.findAll();
    }

    @GetMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car aCar(@PathVariable("plateNumber") String plateNumber) {
        Car car = carRepository.findByPlate(plateNumber);
        if (car == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Car not found");
        }
        return car;
    }

    @PutMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void rent(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam("rent") boolean rent,
            @RequestParam(value = "namePerson", required = false) String namePerson,
            @RequestBody(required = false) Dates dates) throws Exception {
        if (rent) {
            rentalService.rent(plateNumber, namePerson, dates);
        } else {
            rentalService.returnCar(plateNumber);
        }
    }  
}