package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.Matchers.is;

import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./src/main/resources/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithCommentAndEmptyString() {
        String path = "./src/main/resources/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr"));
        assertThat(config.value("surname"), is("Arsentev"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPropHasNoValue() {
        String path = "./src/main/resources/prop_without_value.properties";
        Config config = new Config(path);
        config.load();
    }
}