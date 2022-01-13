package ru.job4j.design.lsp;

public class Warehouse extends Storage {

    @Override
    public boolean accept(Food food) {
        return PercentChecker.checkPercent(food) < 25;
    }
}
