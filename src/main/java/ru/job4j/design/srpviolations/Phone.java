package ru.job4j.design.srpviolations;

public interface Phone {
    String dial(String number);

    String disconnect();

    String sendMessage(String message, String number);

    String receiveMessage(String message);

    void takePhoto();
}
