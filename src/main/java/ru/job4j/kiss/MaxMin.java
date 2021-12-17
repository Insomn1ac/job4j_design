package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return getElement(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return getElement(value, comparator);
    }

    private <T> T getElement(List<T> value, Comparator<T> comparator) {
        T searchedEl = value.get(0);
        for (T el : value) {
            if (comparator.compare(el, searchedEl) > 0) {
                searchedEl = el;
            }
        }
        return searchedEl;
    }
}
