package ru.job4j.gc;

public class User {
    private final String name;
    private final String surname;
    private final int age;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.printf("User %s was removed %n", age);
        } finally {
            super.finalize();
        }
    }
}
