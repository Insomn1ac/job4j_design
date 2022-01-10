package ru.job4j.design.lsp;

public class Warehouse extends Storage {

    @Override
    public void execute(Food food) {
        double percent = food.checkPercent();
        if (percent < 25) {
            foodList.add(food);
        }
    }
}
