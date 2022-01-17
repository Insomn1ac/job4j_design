package ru.job4j.design.dipviolations;

import java.util.ArrayList;

public class FindByName {
    private final Storage storage;

    public FindByName(Storage storage) {
        this.storage = storage;
    }

    public void findByName(String name) {
        if (storage.getStorage().stream()
                .noneMatch(u -> u.getName().equals(name))) {
            System.out.println("Error! User with name \"" + name + "\" not found!");
        }
        storage.getStorage().stream()
                .filter(u -> u.getName().equals(name))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        User user = new User(1, "AAA");
        User user1 = new User(2, "BBB");
        Storage storage = new Storage(new ArrayList<>());
        storage.addToStorage(user, user1);
        FindByName finder = new FindByName(storage);
        finder.findByName("CCC");
        LoginManager lm = new LoginManager();
        System.out.println(lm.validateLogin(user));
    }
}
