package ru.job4j.design.ispviolations;

public class PhoneWithButtons implements Smartphone {
    @Override
    public void doCall() {
        System.out.println("Push-button phone can do calls");
    }

    @Override
    public void sendSms() {
        System.out.println("Push-button phone can send SMS");
    }

    @Override
    public void takePhoto() {
        System.out.println("Push-button phone with camera can take photos");
    }

    @Override
    public void takeVideo() {
        System.out.println("Push-button phone with camera can take videos");
    }

    @Override
    public void goOnline() {
        System.out.println("Cannot going to the Internet");
    }

    @Override
    public void playMusic() {
        System.out.println("Push-button phone can play music");
    }

    @Override
    public void playVideo() {
        System.out.println("Cannot play videos");
    }
}
