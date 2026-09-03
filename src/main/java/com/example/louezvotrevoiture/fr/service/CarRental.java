package com.example.louezvotrevoiture.fr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.louezvotrevoiture.fr.entities.Car;
import com.example.louezvotrevoiture.fr.entities.Dates;

import org.springframework.http.HttpStatus;

@RestController
public class CarRental {

    private List<Car> cars = new ArrayList<>();
    private Dates dates = new Dates("06/09/2026", "11/01/2027");
    public CarRental() {
        cars.add(new Car("11AA22", "Ferrari", 100));
        cars.add(new Car("AA11BB", "FancyCar", 110));
    }

    public Car findCar(String plate, List<Car> cars) {
        for (Car car : cars) {
            if (car.getPlate().equals(plate)) {
                return car;
            }
        }
        return null;
    }

    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Car> listOfCars() {
        return cars;
    }

    @GetMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception {
        Car car = findCar(plateNumber, cars);
        if (car == null) {
        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Car not found"
            );
        }
        return car;
    }
    
    @PutMapping(value = "/voiture/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void rentStatus(
    @PathVariable("plateNumber") String plateNumber,
    @RequestParam(value="rent", required = true) boolean rent) throws Exception{
        Car car = findCar(plateNumber, cars);
        if (car == null) {
        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Car not found"
        );
    }
        if (rent) {
            System.out.println("Rent of the car: " + plateNumber);
            System.out.println("Start : " + dates.getBegin());
            System.out.println("End : " + dates.getEnd());
        }
        else {
            System.out.println("Return of the car: " + plateNumber);
        }
    }
}