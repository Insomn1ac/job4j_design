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
        boolean rsl = false;
        if (vehicle.getCarSize() == 1 && takenSpacesForCars < placesForCars) {
            vehicles[takenSpacesForCars + takenSpacesForTrucks] = vehicle;
            takenSpacesForCars++;
            rsl = true;
        } else if (vehicle.getCarSize() > 1 && takenSpacesForTrucks < placesForTrucks) {
            vehicles[takenSpacesForTrucks + takenSpacesForCars] = vehicle;
            takenSpacesForTrucks++;
            rsl = true;
        } else if (vehicle.getCarSize() > 1
                && takenSpacesForTrucks == placesForTrucks
                && placesForCars - takenSpacesForCars >= vehicle.getCarSize()) {
            for (int i = takenSpacesForCars; i <= placesForCars - vehicle.getCarSize(); i++) {
                vehicles[i] = vehicle;
                takenSpacesForCars++;
            }
            rsl = true;
        }
        return rsl;
    }
}
