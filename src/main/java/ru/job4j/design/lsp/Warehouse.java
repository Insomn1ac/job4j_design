package ru.job4j.design.lsp;

public class Warehouse extends Storage {

    @Override
    public boolean accept(Food food) {
        PercentChecker checker = new PercentChecker(food);
        return checker.checkPercent() < 25;
    }
}
