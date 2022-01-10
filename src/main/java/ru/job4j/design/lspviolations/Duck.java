package ru.job4j.design.lspviolations;

public class Duck {
    public String type = "Duck";

    public void quack() {
        System.out.println(type + " quacks");
    }

    public void fly() {
        System.out.println(type + " flying");
    }
}

class SwampDuck extends Duck {
}

class RobotDuck extends Duck {
    public String type = "Robot duck";

    @Override
    public void fly() {
        System.out.println(type + " cannot fly!");
    }
}

class Test {
    public static void main(String[] args) {
        Duck duck = new SwampDuck();
        Duck robot = new RobotDuck();
        duck.quack();
        duck.fly();
        robot.quack();
        robot.fly();
    }
}
