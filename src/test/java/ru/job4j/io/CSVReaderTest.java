package ru.job4j.io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.nio.file.Files;

public class CSVReaderTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void whenFilterTwoColumns() throws Exception {
        String data = String.join(
                System.lineSeparator(),
                "name;age;last_name;education",
                "Tom;20;Smith;Bachelor",
                "Jack;25;Johnson;Undergraduate",
                "William;30;Brown;Secondary special"
        );
        File file = temporaryFolder.newFile("source.csv");
        File target = temporaryFolder.newFile("target.csv");
        String[] args = new String[]{
                "-path=" + file.getAbsolutePath(), "-delimiter=;", "-out=" + target.getAbsolutePath(), "-filter=name,age"
        };
        CSVReader reader = new CSVReader(args);
        Files.writeString(file.toPath(), data);
        String expected = String.join(
                System.lineSeparator(),
                "name;age",
                "Tom;20",
                "Jack;25",
                "William;30"
        ).concat(System.lineSeparator());
        reader.out(args);
        Assert.assertEquals(expected, Files.readString(target.toPath()));
    }

    @Test
    public void whenFilterOneColumn() throws Exception {

        String data = String.join(
                System.lineSeparator(),
                "name;age;last_name;education",
                "Tom;20;Smith;Bachelor",
                "Jack;25;Johnson;Undergraduate",
                "William;30;Brown;Secondary special"
        );
        File file = temporaryFolder.newFile("source.csv");
        File target = temporaryFolder.newFile("target.csv");
        String[] args = new String[]{
                "-path=" + file.getAbsolutePath(), "-delimiter=;", "-out=" + target.getAbsolutePath(), "-filter=name"
        };
        CSVReader reader = new CSVReader(args);
        Files.writeString(file.toPath(), data);
        String expected = String.join(
                System.lineSeparator(),
                "name",
                "Tom",
                "Jack",
                "William"
        ).concat(System.lineSeparator());
        reader.out(args);
        Assert.assertEquals(expected, Files.readString(target.toPath()));
    }

    @Test
    public void whenFilterThreeParameters() throws Exception {
        String data = String.join(
                System.lineSeparator(),
                "name;age;last_name;education",
                "Tom;20;Smith;Bachelor",
                "Jack;25;Johnson;Undergraduate",
                "William;30;Brown;Secondary special"
        );
        File file = temporaryFolder.newFile("source.csv");
        File target = temporaryFolder.newFile("target.csv");
        String[] args = new String[]{
                "-path=" + file.getAbsolutePath(), "-delimiter=;", "-out=" + target.getAbsolutePath(), "-filter=age,last_name,education"
        };
        CSVReader reader = new CSVReader(args);
        Files.writeString(file.toPath(), data);
        String expected = String.join(
                System.lineSeparator(),
                "age;last_name;education",
                "20;Smith;Bachelor",
                "25;Johnson;Undergraduate",
                "30;Brown;Secondary special"
        ).concat(System.lineSeparator());
        reader.out(args);
        Assert.assertEquals(expected, Files.readString(target.toPath()));
    }
}