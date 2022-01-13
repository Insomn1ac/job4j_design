package ru.job4j.design.lsp;

public class Trash extends Storage {

    @Override
    public boolean accept(Food food) {
        return PercentChecker.checkPercent(food) >= 100;
    }
}
