package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TemplateEngineTest {

    @Ignore
    @Test
    public void whenMapHaveAKeyThenStringsEquals() {
        Generator templateEngine = new TemplateEngine();
        Map<String, String> input = new HashMap<>();
        input.put("name", "Petr Arsentev");
        input.put("subject", "you");
        String template = "I am a ${name}, Who are ${subject}?";
        String expected = "I am a Petr Arsentev, Who are you?";
        String rsl = templateEngine.produce(template, input);
        assertEquals(expected, rsl);
    }

    @Ignore
    @Test (expected = IllegalArgumentException.class)
    public void whenMapHaveNotANameKeyThenExceptionExpected() {
        Generator templateEngine = new TemplateEngine();
        Map<String, String> input = new HashMap<>();
        input.put("post", "director");
        input.put("subject", "you");
        String template = "I am a ${name}, Who are ${subject}?";
        String rsl = templateEngine.produce(template, input);
    }

    @Ignore
    @Test (expected = IllegalArgumentException.class)
    public void whenTemplateHaveNotASubjectKeyThenExceptionExpected() {
        Generator templateEngine = new TemplateEngine();
        Map<String, String> input = new HashMap<>();
        input.put("post", "director");
        input.put("subject", "you");
        String template = "I am a ${post}";
        String rsl = templateEngine.produce(template, input);
    }
}