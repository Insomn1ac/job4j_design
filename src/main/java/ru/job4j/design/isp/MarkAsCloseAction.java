package ru.job4j.design.isp;

public class MarkAsCloseAction implements Action {

    @Override
    public String doAction() {
        return " closed.";
    }
}
