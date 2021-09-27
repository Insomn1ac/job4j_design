package ru.job4j.serialization.json;

public class Contact {
    private final String phone;
    private final String telegram;

    public Contact(String phone, String telegram) {
        this.phone = phone;
        this.telegram = telegram;
    }

    public String getPhone() {
        return phone;
    }

    public String getTelegram() {
        return telegram;
    }

    @Override
    public String toString() {
        return "{"
                + "phone='" + phone + '\''
                + ", telegram='" + telegram + '\''
                + "}";
    }
}