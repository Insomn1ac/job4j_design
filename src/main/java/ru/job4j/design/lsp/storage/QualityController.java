package ru.job4j.design.lsp.storage;

import java.util.ArrayList;
import java.util.List;

public class QualityController {
    private final List<Storage> storage;

    public QualityController(List<Storage> storage) {
        this.storage = storage;
    }

    public void executeStorage(Food food) {
        for (Storage store : storage) {
            store.execute(food);
        }
    }

    public void resort() {
        List<Food> foodList = new ArrayList<>();
        storage.forEach(s -> foodList.addAll(s.getFoodList()));
        storage.forEach(Storage::deleteFoodFromStorage);
        foodList.forEach(this::executeStorage);
    }
}
