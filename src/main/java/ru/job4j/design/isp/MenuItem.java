package ru.job4j.design.isp;

public class MenuItem implements Menu {
    private final String name;
    private Action action;

    public MenuItem(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    public MenuItem(String name) {
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
    }
}
