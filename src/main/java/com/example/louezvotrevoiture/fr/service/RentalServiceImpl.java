package com.example.louezvotrevoiture.fr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.louezvotrevoiture.fr.entities.Car;
import com.example.louezvotrevoiture.fr.entities.CarRepository;

@Service 
 public class RentalServiceImpl { 
      
   CarRepository carRepository; 
  
   @Autowired
   public RentalServiceImpl(CarRepository carRepository) { 
      super(); 
      this.carRepository = carRepository; 
     }

   public void addCar(Car car) {
         carRepository.save(car);
   }
}