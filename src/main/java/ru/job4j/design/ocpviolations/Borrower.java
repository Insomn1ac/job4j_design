package ru.job4j.design.ocpviolations;

public class Borrower {
    private final String name;
    private final String surname;
    private final int age;
    private final double salary;
    private final boolean isWanted;

    public Borrower(String name, String surname, int age, double salary, boolean isWanted) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
        this.isWanted = isWanted;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isWanted() {
        return isWanted;
    }
}
