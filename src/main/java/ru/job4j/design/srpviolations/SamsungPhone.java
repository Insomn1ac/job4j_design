package ru.job4j.design.srpviolations;

public class SamsungPhone implements Phone {

    @Override
    public String dial(String number) {
        return "Calling to " + number;
    }

    @Override
    public String disconnect() {
        return "Call ended.";
    }

    @Override
    public String sendMessage(String message, String number) {
        return "Message " + message + " was sent to number " + number;
    }

    @Override
    public String receiveMessage(String message) {
        return "Incoming message: " + message;
    }

    @Override
    public void takePhoto() {
    }
}
