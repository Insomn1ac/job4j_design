package ru.job4j.design.lsp.parking;

public class Car implements Vehicle {
    private static final int SIZE = 1;

    @Override
    public int getCarSize() {
        return SIZE;
    }
}
