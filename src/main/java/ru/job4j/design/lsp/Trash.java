package ru.job4j.design.lsp;

public class Trash extends Storage {

    @Override
    public void execute(Food food) {
        double percent = food.checkPercent();
        if (percent >= 100) {
            foodList.add(food);
        }
    }
}
