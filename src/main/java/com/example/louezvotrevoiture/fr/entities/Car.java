package com.example.louezvotrevoiture.fr.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
    @SequenceGenerator(name = "car_seq", sequenceName = "car_id_seq", allocationSize = 1)
    private Long id;
    
    private String plate;
    private String marque;
    private int price;

    @OneToOne(cascade = CascadeType.ALL)
    private Contract contract;

    public Car() {
    }

    public Car(String plate, String marque, int price) {
        this.plate = plate;
        this.marque = marque;
        this.price = price;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public void rent(Person person, Dates dates) {
        Contract contract = new Contract();
        contract.setCar(this);
        contract.setPerson(person);
        contract.setBegin(dates.getBegin());
        contract.setEnd(dates.getEnd());
        this.contract = contract;
    }
}