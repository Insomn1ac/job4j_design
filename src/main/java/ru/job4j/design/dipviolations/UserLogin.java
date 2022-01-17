package ru.job4j.design.dipviolations;

public class UserLogin {

    public String auth(User user) {
        if (user.getId() < 3) {
            return user.getName() + " successfully authenticated";
        } else {
            return user.getName() + " not authenticated";
        }
    }
}
