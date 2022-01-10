package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public abstract class Storage {
    List<Food> foodList = new ArrayList<>();

    public List<Food> foodInStorage() {
        return foodList;
    }

    public abstract void execute(Food food);
}
