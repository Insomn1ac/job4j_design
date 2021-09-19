package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    private final String delimiter;
    private final List<String> filter;
    private final Path output;
    private final Path path;
    private final StringBuilder sb = new StringBuilder();

    public CSVReader(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        this.delimiter = argsName.get("delimiter");
        this.filter = List.of(argsName.get("filter").split(","));
        this.output = Path.of(argsName.get("out"));
        this.path = Path.of(argsName.get("path"));
    }

    private void isValid(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Enter a valid number of arguments.");
        }
        Path output = Paths.get(args[2].replaceFirst("-out=", ""));
        Path path = Paths.get(args[0].replaceFirst("-path=", ""));
        if (!path.toFile().isFile()) {
            throw new IllegalArgumentException("File doesn't exist.");
        }
        if (!"stdout".equals(output.toString())) {
            if (!path.toFile().exists()) {
                throw new IllegalArgumentException("Enter a valid output path.");
            }
        }
    }

    public void handle(String[] args) {
        CSVReader reader = new CSVReader(args);
        reader.isValid(args);
        List<Integer> column = new ArrayList<>();
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(path.toFile())))) {
            while (sc.hasNextLine()) {
                String[] read = sc.nextLine().split(delimiter);
                    for (int i = 0; i < read.length; i++) {
                        if (filter.contains(read[i])) {
                            column.add(i);
                        }
                    }
                    for (int num : column) {
                        sb.append(read[num]).append(";");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void out(String[] args) {
        handle(args);
        if ("stdout".equals(output.toString())) {
            System.out.println(sb);
        } else {
            try (BufferedWriter out = new BufferedWriter(new FileWriter(output.toFile()))) {
                out.write(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CSVReader reader = new CSVReader(args);
        reader.out(args);
    }
}