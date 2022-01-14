package ru.job4j.design.lsp.storage;

public class Shop extends Storage {

    @Override
    public boolean accept(Food food) {
        double percent = PercentChecker.checkPercent(food);
        if (percent >= 25 && percent < 100) {
            if (percent > 75) {
                food.setPrice(food.getPrice() - (food.getPrice() * ((double) food.getDiscount() / 100)));
            }
            return true;
        }
        return false;
    }
}
