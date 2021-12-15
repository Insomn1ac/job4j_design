package ru.job4j.cache;

import java.util.Scanner;

public class Emulator {
    private static AbstractCache<String, String> cache;
    private static final Scanner SCANNER = new Scanner(System.in);

    private static AbstractCache<String, String> getAbstractCache() {
        System.out.println("Enter a path to directory"
                + System.lineSeparator());
        String pathToDir = SCANNER.nextLine();
        cache = new DirFileCache(pathToDir);
        return cache;
    }

    public static void main(String[] args) {
        boolean infCycle = true;
        while (infCycle) {
            System.out.println(System.lineSeparator()
                    + "1. Directory" + System.lineSeparator()
                    + "2. File" + System.lineSeparator()
                    + "3. Exit"
            );
            String userChoice = SCANNER.nextLine();
            if ("3".equals(userChoice)) {
                infCycle = false;
            } else if ("1".equals(userChoice)) {
                cache = getAbstractCache();
            } else if ("2".equals(userChoice)) {
                if (cache == null) {
                    cache = getAbstractCache();
                }
                System.out.println("Enter a name of file"
                        + System.lineSeparator());
                String file = SCANNER.nextLine().toLowerCase();
                System.out.println(cache.get(file));
            }
        }
    }
}
