package ru.job4j.design.isp;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Menu {
    private final List<Menu> menuList = new ArrayList<>();
    private final String name;
    private Action action;

    public Composite(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    public Composite(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void showMenu() {
        if (action != null) {
            System.out.printf("%-30s %s%n", getName(), action.doAction());
        } else {
            System.out.println(getName());
        }
        for (Menu menu : menuList) {
            menu.showMenu();
        }
    }

    public void addToMenu(Menu menu) {
        if (!menu.getName().contains(name)) {
            throw new IllegalArgumentException("Task \"" + menu.getName() + "\" cannot be put into \"" + name + "\"");
        }
        menuList.add(menu);
    }
}
