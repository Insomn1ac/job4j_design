package ru.job4j.serialization.xml;

import java.util.Arrays;

public class Car {
    private final String model;
    private final String year;
    private final String color;
    private final boolean isJacked;
    private final Engine engine;
    private final String[] characteristics;

    public Car(String model, String year, String color, boolean isJacked, Engine engine, String... characteristics) {
        this.model = model;
        this.year = year;
        this.color = color;
        this.isJacked = isJacked;
        this.engine = engine;
        this.characteristics = characteristics;
    }

    @Override
    public String toString() {
        return "Car{"
                + "model='" + model + '\''
                + ", year='" + year + '\''
                + ", color='" + color + '\''
                + ", isJacked=" + isJacked
                + ", engine=" + engine
                + ", characteristics=" + Arrays.toString(characteristics)
                + '}';
    }
}
