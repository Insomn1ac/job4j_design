package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("C:/projects/job4j_design/src/main/resources/log.txt"))) {
            rsl = in.lines()
                    .filter(s -> s.contains("404"))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)))) {
            for (String str : log) {
                out.printf("%s%n", str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("C:/projects/job4j_design/src/main/resources/log.txt");
        for (String s : log) {
            System.out.println(s);
        }
        save(log, "C:/projects/job4j_design/src/main/resources/404.txt");
    }
}
