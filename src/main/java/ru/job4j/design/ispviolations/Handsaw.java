package ru.job4j.design.ispviolations;

public class Handsaw implements Tools {

    @Override
    public void screw() {
        System.out.println("Handsaw cannot screw");
    }

    @Override
    public void nail() {
        System.out.println("Handsaw cannot nail");
    }

    @Override
    public void saw() {
        System.out.println("Handsaw can saw something");
    }

    @Override
    public void cut() {
        System.out.println("Handsaw cannot cut");
    }
}
