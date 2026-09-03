package com.example.louezvotrevoiture.fr.entities;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findByPlate(String plate); 
}


