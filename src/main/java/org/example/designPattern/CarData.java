package org.example.designPattern;

public class CarData {
    private String brand;
    private String model;
    private String year;
    private String color;
    private double price;

    public CarData(String brand, String model, String year, String color, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }
}

