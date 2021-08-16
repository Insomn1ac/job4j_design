package ru.job4j.collection.map;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SimpleMapTest {

    @Test
    public void whenPutAndGet() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Ivanov");
        map.put(2, "Petrov");
        assertThat(map.get(1), is("Ivanov"));
        assertThat(map.get(2), is("Petrov"));
    }

    @Test
    public void whenPutAndRemove() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(2, "Petrov");
        map.put(3, "Sidorov");
        assertTrue(map.remove(3));
        assertNull(map.get(3));
    }

    @Test
    public void whenRemove() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        assertFalse(map.remove(1));
    }

    @Test
    public void whenPutAndGetEmpty() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Ivanov");
        map.put(3, "Petrov");
        assertNull(map.get(2));
    }

    @Test
    public void whenMapExpand() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(1, "Ivanov");
        map.put(2, "Petrov");
        map.put(3, "Sidorov");
        map.put(4, "Volkov");
        map.put(5, "Stepanov");
        map.put(6, "Sergeev");
        map.put(7, "Vasilyev");
        map.put(8, "Suvorov");
        map.put(9, "Vladimirov");
        assertEquals("Vasilyev", map.get(7));
        assertEquals("Vladimirov", map.get(9));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        Iterator<Integer> it = map.iterator();
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(1, "Ivanov");
        Iterator<Integer> it = map.iterator();
        map.put(2, "Petrov");
        it.next();
    }
}