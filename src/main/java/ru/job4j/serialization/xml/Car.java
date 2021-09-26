package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {

    @XmlAttribute
    private String model;

    @XmlAttribute
    private String year;

    @XmlAttribute
    private String color;

    @XmlAttribute
    private boolean isJacked;

    private Engine engine;

    @XmlElementWrapper
    @XmlElement(name = "characteristic")
    private String[] characteristics;

    public Car() {

    }

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
        return "{"
                + "model='" + model + '\''
                + ", year='" + year + '\''
                + ", color='" + color + '\''
                + ", isJacked=" + isJacked
                + ", engine=" + engine
                + ", characteristics=" + Arrays.toString(characteristics)
                + '}';
    }
}
