package ru.job4j.design.ispviolations;

public class SomeCar implements CarSelector {
    private final String brand;
    private final String model;

    public SomeCar(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public void selectEngine() {
        System.out.println("Engine power is 122 HP");
    }

    @Override
    public void selectTransmission() {
        System.out.println("Transmission is mechanic");
    }

    @Override
    public void selectHeadlights() {
        System.out.println("LED headlights");
    }

    @Override
    public void selectPanoramicSunroof() {
        System.out.println("Non-panoramic sunroof");
    }

    @Override
    public void selectSeats() {
        System.out.println("Ventilated seats");
    }
}
