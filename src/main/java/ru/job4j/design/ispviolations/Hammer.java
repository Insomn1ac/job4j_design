package ru.job4j.design.ispviolations;

public class Hammer implements Tools {

    @Override
    public void screw() {
        System.out.println("Hammer cannot screw");
    }

    @Override
    public void nail() {
        System.out.println("Hammer can nail");
    }

    @Override
    public void saw() {
        System.out.println("Hammer cannot saw");
    }

    @Override
    public void cut() {
        System.out.println("Hammer cannot cut");
    }
}
