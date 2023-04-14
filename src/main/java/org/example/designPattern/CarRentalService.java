package org.example.designPattern;

public class CarRentalService {
    public static void main(String[] args) {
        CarData carData = new CarData("Ford", "Mustang", "2021", "Red", 50.0);
        Car car = new CarDataAdapter(carData);
        System.out.println("Brand: " + car.getBrand());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Color: " + car.getColor());
        System.out.println("Price: " + car.getPrice());
    }
}
