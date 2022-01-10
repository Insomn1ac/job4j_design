package ru.job4j.design.lsp;

public class Shop extends Storage {

    @Override
    public void execute(Food food) {
        double percent = food.checkPercent();
        if (percent >= 25 && percent < 100) {
            if (percent > 75) {
                food.setPrice(food.getPrice() - (food.getPrice() * ((double) food.getDiscount() / 100)));
            }
            foodList.add(food);
        }
    }
}
