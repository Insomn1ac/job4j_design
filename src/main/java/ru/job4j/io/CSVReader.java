package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) {
        String delimiter = argsName.get("delimiter");
        Path output = Paths.get(argsName.get("out"));
        Path path = Paths.get(argsName.get("path"));
        List<String> filter = List.of(argsName.get("filter").split(","));
        List<List<String>> csvOutput = new ArrayList<>();
        if (!path.toFile().isFile()) {
            throw new IllegalArgumentException();
        }
        if (!"stdout".equals(output.toString())) {
            if (!path.toFile().exists()) {
                throw new IllegalArgumentException();
            }
        }
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(path.toFile()))).useDelimiter(";")) {
            while (sc.hasNextLine()) {
                List<String> list = new ArrayList<>(Arrays.asList(sc.nextLine().split(delimiter)));
                csvOutput.add(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> first = csvOutput.get(0);
        List<Integer> column = new ArrayList<>();
        for (String f : filter) {
            column.add(first.indexOf(f));
        }
        StringBuilder sb = new StringBuilder();
        for (List<String> strings : csvOutput) {
            for (int num : column) {
                sb.append(strings.get(num)).append(";");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(System.lineSeparator());
        }
        try (BufferedWriter out = new BufferedWriter(new FileWriter(output.toFile()))) {
            if ("stdout".equals(output.toString())) {
                System.out.println(sb);
            } else {
                out.write(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CSVReader.handle(ArgsName.of(args));
    }
}
