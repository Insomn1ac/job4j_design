package ru.job4j.serialization.xml;

public class Engine {
    private final int horsePower;
    private final int torque;

    public Engine(int horsePower, int torque) {
        this.horsePower = horsePower;
        this.torque = torque;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "HP=" + horsePower
                + ", torque=" + torque
                + '}';
    }
}
