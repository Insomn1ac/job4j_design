package ru.job4j.design.ocpviolations;

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

    public void convertToBMPAndSave(String path) {

    }
}
