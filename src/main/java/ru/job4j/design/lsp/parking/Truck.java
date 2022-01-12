package ru.job4j.design.lsp.parking;

public class Truck implements Vehicle {
    private final int size;

    public Truck(int size) {
        this.size = size;
    }

    @Override
    public int getCarSize() {
        if (size < 2) {
            throw new IllegalArgumentException("Truck size must be more than 1 space!");
        }
        return size;
    }
}
