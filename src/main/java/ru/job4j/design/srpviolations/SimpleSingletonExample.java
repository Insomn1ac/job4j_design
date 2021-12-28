package ru.job4j.design.srpviolations;

public final class SimpleSingletonExample {
    private static SimpleSingletonExample instance = null;

    private SimpleSingletonExample() {
    }

    public static SimpleSingletonExample getInstance() {
        if (instance == null) {
            instance = new SimpleSingletonExample();
        }
        return instance;
    }
}
