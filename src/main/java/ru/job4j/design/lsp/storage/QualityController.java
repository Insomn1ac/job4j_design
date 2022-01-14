package ru.job4j.design.lsp.storage;

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
}
