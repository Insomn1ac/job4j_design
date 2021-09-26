package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "engine")
public class Engine {

    @XmlAttribute
    private int horsePower;

    @XmlAttribute
    private int torque;

    public Engine() {

    }

    public Engine(int horsePower, int torque) {
        this.horsePower = horsePower;
        this.torque = torque;
    }

    @Override
    public String toString() {
        return "{"
                + "HP=" + horsePower
                + ", torque=" + torque
                + '}';
    }
}
