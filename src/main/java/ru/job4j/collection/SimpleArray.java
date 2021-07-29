package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    transient Object[] container;
    private int size;
    private int modCount;

    public SimpleArray() {
        container = new Object[10];
    }

    public SimpleArray(int i) {
        container = new Object[i];
    }

    public void ensureCapacity(int size) {
        int oldCapacity = container.length;
        if (size == oldCapacity) {
            int newCapacity = (oldCapacity * 3) / 2 + 1;
            Object[] tempContainer = new Object[newCapacity];
            System.arraycopy(container, 0, tempContainer, 0, size);
            container = tempContainer;
        }
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) container[index];
    }

    public void add(T model) {
        ensureCapacity(size);
        container[size++] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int point = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[point++];
            }
        };
    }
}
