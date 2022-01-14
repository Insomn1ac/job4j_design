package ru.job4j.design.lsp.storage;

import java.time.LocalDate;

public class Fish extends Food {
    public Fish(String name, LocalDate expiryDate, LocalDate createDate, double price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
