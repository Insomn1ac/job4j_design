package ru.job4j.design.lsp.storage;

import java.util.ArrayList;
import java.util.List;

public abstract class Storage {
    private final List<Food> foodList = new ArrayList<>();

    public List<Food> getFoodList() {
        return new ArrayList<>(foodList);
    }

    public boolean execute(Food food) {
        if (accept(food)) {
            return foodList.add(food);
        }
        return false;
    }

    public abstract boolean accept(Food food);
}
