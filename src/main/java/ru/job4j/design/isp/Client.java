package ru.job4j.design.isp;

public class Client {
    public static void main(String[] args) {
        Menu leaf1 = new MenuItem("--------- Задача 1.1.1.", new MarkAsCloseAction());
        Menu leaf2 = new MenuItem("--------- Задача 1.1.2.", new ReturnForReworkAction());
        Composite composite1 = new Composite("---- Задача 1.1.");
        composite1.addToMenu(leaf1);
        composite1.addToMenu(leaf2);
        Composite composite2 = new Composite("---- Задача 1.2.", new MarkAsCloseAction());
        Composite main = new Composite("Задача 1.", new ReturnForReworkAction());
        main.addToMenu(composite1);
        main.addToMenu(composite2);
        main.showMenu();
    }
}
