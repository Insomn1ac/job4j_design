package ru.job4j.design.dipviolations;

public class LoginManager {
    private final UserLogin userLogin = new UserLogin();

    public String validateLogin(User user) {
        if (userLogin.auth(user).contains("successfully")) {
            return userLogin.auth(user);
        } else {
            return "";
        }
    }
}
