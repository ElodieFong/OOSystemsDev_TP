package com.example.louezvotrevoiture.fr.data;

public class Car {
    private String plate;
    private String marque;
    private int price;

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
}
