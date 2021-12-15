package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        Path path = Path.of(cachingDir + "\\" + key);
        Optional<String> rsl = Optional.empty();
        try {
            rsl = Optional.of(Files.readString(path));
        } catch (IOException e) {
            System.out.println("File with the entered name was not found");
        }
        return rsl.orElse("Enter a valid name of file");
    }
}