package ru.job4j.design.dipviolations;

import java.util.Arrays;
import java.util.List;

public class Storage {
    private final List<User> storage;

    public Storage(List<User> storage) {
        this.storage = storage;
    }

    public List<User> getStorage() {
        return storage;
    }

    public void addToStorage(User... users) {
        storage.addAll(Arrays.asList(users));
    }
}
