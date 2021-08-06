package ru.job4j.collection.set;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAddNullAndOne() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
        assertFalse(set.contains(2));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenEmptySetThenIt() {
        Set<Integer> set = new SimpleSet<>();
        Iterator<Integer> it = set.iterator();
        it.next();
    }
}