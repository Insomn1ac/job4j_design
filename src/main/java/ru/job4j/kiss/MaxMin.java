package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return getElement(value, comparator, i -> i > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return getElement(value, comparator, i -> i < 0);
    }

    private <T> T getElement(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T searchedEl = value.get(0);
        for (T el : value) {
            if (predicate.test(comparator.compare(el, searchedEl))) {
                searchedEl = el;
            }
        }
        return searchedEl;
    }
}
