package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static int[][] multiple(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = (i + 1) * (j + 1);
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[][] array = multiple(10);
        try (FileOutputStream out = new FileOutputStream("C:/projects/job4j_design/src/main/resources/result.txt")) {
            for (int[] row : array) {
                for (int el : row) {
                    if (el / 10 < 1) {
                        out.write(("  " + el).getBytes());
                    } else {
                        out.write((" " + el).getBytes());
                    }
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
