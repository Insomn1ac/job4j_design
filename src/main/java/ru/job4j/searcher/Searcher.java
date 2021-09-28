package ru.job4j.searcher;

import ru.job4j.io.SearchFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class Searcher {
    private static final HashMap<String, String> KEYS = new HashMap<>();

    public void isValid(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Enter a valid number of arguments");
        }
        for (String key : args) {
            String[] argument = key.split("=");
            if (argument.length != 2) {
                throw new IllegalArgumentException("Enter a valid key");
            }
            KEYS.put(argument[0], argument[1]);
        }
        String[] keysArray = new String[] {"-d", "-n", "-t", "-o"};
        for (String key : keysArray) {
            if (!KEYS.containsKey(key)) {
                throw new IllegalArgumentException("Key doesn't exist");
            }
        }
    }

    public List<Path> search(Path root, Predicate<Path> condition) {
        SearchFiles searcher = new SearchFiles(condition);
        try {
            Files.walkFileTree(root, searcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searcher.getPaths();
    }

    public void out(List<Path> paths) {
        try (PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(KEYS.get("-o"))))) {
            if (paths.isEmpty()) {
                out.println("File not found");
            }
            for (Path path : paths) {
                out.println(path.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Predicate<Path> condition() {
        Predicate<Path> condition;
        if ("name".equals(KEYS.get("-t"))) {
            condition = p -> p.toFile().getName().equals(KEYS.get("-n"));
        } else if ("mask".equals(KEYS.get("-t"))) {
            condition = p -> p.toFile().getName().contains(KEYS.get("-n").split("\\*")[1]);
        } else {
            throw new IllegalArgumentException("Enter a \"name\" or \"mask\" key");
        }
        return condition;
    }

    public static void main(String[] args) {
        Searcher searcher = new Searcher();
        searcher.isValid(args);
        Path directory = Paths.get(KEYS.get("-d"));
        List<Path> found = searcher.search(directory, searcher.condition());
        searcher.out(found);
    }
}
