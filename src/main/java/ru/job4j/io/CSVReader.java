package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {

    public void isValid(String[] args) {
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

    public void handle(ArgsName argsName) {
        String delimiter = argsName.get("delimiter");
        Path output = Paths.get(argsName.get("out"));
        Path path = Paths.get(argsName.get("path"));
        List<String> filter = List.of(argsName.get("filter").split(","));
        List<List<String>> csvOutput = new ArrayList<>();
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
        CSVReader reader = new CSVReader();
        reader.isValid(args);
        reader.handle(ArgsName.of(args));
    }
}
