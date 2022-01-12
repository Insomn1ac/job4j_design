package ru.job4j.design.lsp.parking;

public class OutdoorParking implements Parking {
    private final int placesForCars;
    private final int placesForTrucks;
    private final Vehicle[] vehicles;
    private int takenSpacesForCars;
    private int takenSpacesForTrucks;

    public OutdoorParking(int placesForCars, int placesForTrucks) {
        this.placesForCars = placesForCars;
        this.placesForTrucks = placesForTrucks;
        this.vehicles = new Vehicle[placesForCars + placesForTrucks];
    }

    public int getPlacesForCars() {
        return placesForCars;
    }

    public int getPlacesForTrucks() {
        return placesForTrucks;
    }

    public Vehicle[] getVehicles() {
        return vehicles.clone();
    }

    public int getTakenSpacesForCars() {
        return takenSpacesForCars;
    }

    public int getTakenSpacesForTrucks() {
        return takenSpacesForTrucks;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        return false;
    }
}
