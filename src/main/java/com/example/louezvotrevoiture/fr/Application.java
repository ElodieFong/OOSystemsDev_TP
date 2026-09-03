package com.example.louezvotrevoiture.fr;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.louezvotrevoiture.fr.entities.Car;
import com.example.louezvotrevoiture.fr.service.RentalServiceImpl;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean 
     public CommandLineRunner demo(RentalServiceImpl carRentalService) { 
        return (args) -> { 
           Car car = new Car("11AA22", "Ferrari", 1000); 
           carRentalService.addCar(car); 
           car = new Car("22BB44", "Porshe", 2000); 
           carRentalService.addCar(car); 
        }; 
     };
}
