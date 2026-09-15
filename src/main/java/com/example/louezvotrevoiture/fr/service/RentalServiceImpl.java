package com.example.louezvotrevoiture.fr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.louezvotrevoiture.fr.entities.Car;
import com.example.louezvotrevoiture.fr.entities.CarRepository;
import com.example.louezvotrevoiture.fr.entities.Dates;
import com.example.louezvotrevoiture.fr.entities.Person;
import com.example.louezvotrevoiture.fr.entities.PersonRepository;

@Service
public class RentalServiceImpl {
    private CarRepository carRepository;
    private PersonRepository personRepository;

    @Autowired
    public RentalServiceImpl(CarRepository carRepository, PersonRepository personRepository) {
        this.carRepository = carRepository;
        this.personRepository = personRepository;
    }

    public void addCar(Car car) {
        carRepository.save(car);
    }

    public void rent(String plate, String namePerson, Dates dates) 
    throws Exception {
        Car car = carRepository.findByPlate(plate);
        Person person = personRepository.findByName(namePerson);
        if (car == null) {
            throw new Exception("Car not found");
        }
        if (person == null) {
            throw new Exception("Person not found");
        }
        car.rent(person, dates);
        carRepository.save(car);
    }

    public void returnCar(String plate) throws Exception {
        Car car = carRepository.findByPlate(plate);
        if (car == null) {
            throw new Exception("Car not found");
        }
        car.setContract(null);
        carRepository.save(car);
    }
}