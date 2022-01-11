package ru.job4j.design.lsp.parking;

public class OutdoorParking implements Parking {
    private final int placesForCars;
    private final int placesForTrucks;
    private final Vehicle[] vehicles;

    public OutdoorParking(int placesForCars, int placesForTrucks, Vehicle[] vehicles) {
        this.placesForCars = placesForCars;
        this.placesForTrucks = placesForTrucks;
        this.vehicles = vehicles;
    }

    public int getPlacesForCars() {
        return placesForCars;
    }

    public int getPlacesForTrucks() {
        return placesForTrucks;
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        return false;
    }
}
