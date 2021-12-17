package ru.job4j.kiss;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void whenFindMax() {
        MaxMin rsl = new MaxMin();
        Comparator<Integer> comp = Comparator.naturalOrder();
        List<Integer> list = List.of(3, 7, 1, 9, 7);
        Integer expected = 9;
        assertEquals(expected, rsl.max(list, comp));
    }

    @Test
    public void whenFindMin() {
        MaxMin rsl = new MaxMin();
        Comparator<Integer> comp = Comparator.reverseOrder();
        List<Integer> list = List.of(18, 4, 75, 2, 84, 1, 9);
        Integer expected = 1;
        assertEquals(expected, rsl.min(list, comp));
    }

    @Test
    public void whenFindMinLetter() {
        MaxMin rsl = new MaxMin();
        Comparator<Character> comp = Comparator.reverseOrder();
        List<Character> list = List.of('a', 'G', 't', 'A', 'X');
        Character expected = 'A';
        assertEquals(expected, rsl.min(list, comp));
    }
}