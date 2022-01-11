package ru.job4j.design.lsp.parking;

public class Truck implements Vehicle {
    private static final int SIZE = 2;

    @Override
    public int getCarSize() {
        return SIZE;
    }
}
