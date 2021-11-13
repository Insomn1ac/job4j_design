package ru.job4j.gc;

public class UserDemo {

    public static void main(String[] args) {
        GCDemo.info();
        for (int i = 0; i < 9000; i++) {
            new User("name" + i, "surname" + i, i);
        }
        GCDemo.info();
    }
}
