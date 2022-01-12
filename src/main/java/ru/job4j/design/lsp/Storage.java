package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public abstract class Storage {
    List<Food> foodList = new ArrayList<>();

    public List<Food> foodInStorage() {
        return foodList;
    }

    public boolean execute(Food food) {
        if (accept(food)) {
            return foodList.add(food);
        }
        return false;
    }

    public abstract boolean accept(Food food);
}
