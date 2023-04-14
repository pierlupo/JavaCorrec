package org.example.designPattern;

public class CarDataAdapter implements Car {
    private CarData carData;

    public CarDataAdapter(CarData carData) {
        this.carData = carData;
    }

    @Override
    public String getBrand() {
        return carData.getBrand();
    }

    @Override
    public String getModel() {
        return carData.getModel();
    }

    @Override
    public int getYear() {
        return Integer.parseInt(carData.getYear());
    }

    @Override
    public String getColor() {
        return carData.getColor();
    }

    @Override
    public double getPrice() {
        return carData.getPrice();
    }
}
