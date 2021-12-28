package ru.job4j.design.srpviolations;

public class JpgImage {
    private int height;
    private int width;

    public JpgImage(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getImageSize() {
        return height * width;
    }

    public void save(String path) {

    }

    public void sendToEmail(String email, String text) {

    }

    public void uploadToServer(String port, String user, String password) {

    }
}
