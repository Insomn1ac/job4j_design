package ru.job4j.design.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class OutdoorParkingTest {

    @Test
    @Ignore
    public void whenParkSomeDifferentCars() {
        Parking parking = new OutdoorParking(2, 1);
        Vehicle car1 = new Car();
        Vehicle car2 = new Car();
        Vehicle truck1 = new Truck(10);
        Vehicle truck2 = new Truck(2);
        assertTrue(parking.park(car1));
        assertTrue(parking.park(car2));
        assertTrue(parking.park(truck1));
        assertFalse(parking.park(truck2));
    }

    @Test
    @Ignore
    public void whenParkOnlySmallCars() {
        Parking parking = new OutdoorParking(2, 0);
        Vehicle car1 = new Car();
        Vehicle car2 = new Car();
        Vehicle car3 = new Car();
        assertTrue(parking.park(car1));
        assertTrue(parking.park(car2));
        assertFalse(parking.park(car3));
    }

    @Test
    @Ignore
    public void whenParkTrucksOnDifferentSpaces() {
        Parking parking = new OutdoorParking(3, 1);
        Vehicle truck1 = new Truck(4);
        Vehicle truck2 = new Truck(2);
        Vehicle truck3 = new Truck(2);
        assertTrue(parking.park(truck1));
        assertTrue(parking.park(truck2));
        assertFalse(parking.park(truck3));
    }

    @Test
    @Ignore
    public void whenParkingHasNotEnoughSpaceToPark() {
        Parking parking = new OutdoorParking(0, 0);
        Vehicle car = new Car();
        assertFalse(parking.park(car));
    }

    @Test
    @Ignore
    public void whenParkCarsOnDifferentSpacesThenGetTakenSpaces() {
        OutdoorParking parking = new OutdoorParking(2, 1);
        Vehicle car1 = new Car();
        Vehicle car2 = new Car();
        Vehicle truck1 = new Truck(2);
        assertTrue(parking.park(car1));
        assertTrue(parking.park(car2));
        assertTrue(parking.park(truck1));
        assertThat(parking.getTakenSpacesForCars(), is(2));
        assertThat(parking.getTakenSpacesForTrucks(), is(1));
    }

    @Test
    @Ignore
    public void whenReturnAllVehiclesThatBeenParked() {
        OutdoorParking parking = new OutdoorParking(1, 1);
        Vehicle car = new Car();
        Vehicle truck = new Truck(2);
        assertTrue(parking.park(car));
        assertTrue(parking.park(truck));
        assertThat(parking.getVehicles(), is(new Vehicle[] {car, truck}));
    }
}