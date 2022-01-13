package ru.job4j.design.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PercentChecker {

    public static double checkPercent(Food food) {
        long bestBefore = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long fromCreateToNow = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now());
        return (double) fromCreateToNow / bestBefore * 100;
    }
}
