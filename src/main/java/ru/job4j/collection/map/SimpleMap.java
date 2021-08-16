package ru.job4j.collection.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int size = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (size + 1 >= (table.length * LOAD_FACTOR)) {
            expand();
        }
        int index = hash(key);
        if (table[index] != null) {
            return false;
        }
        table[index] = new MapEntry<>(key, value);
        size++;
        modCount++;
        return true;
    }

    private int hash(Object o) {
        return o.hashCode() ^ (o.hashCode() >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    @SuppressWarnings("unchecked")
    private void expand() {
        MapEntry<K, V>[] expanded = new MapEntry[capacity * 2];
        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                int rehashIndex = indexFor(hash(entry.key.hashCode()));
                expanded[rehashIndex] = entry;
            }
        }
        table = expanded;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        if (table[index] == null || !Objects.equals(table[index].key, key)) {
            return null;
        }
        return table[index].value;
    }

    @Override
    public boolean remove(K key) {
        int index = hash(key);
        if (table[index] == null || !Objects.equals(table[index].key, key)) {
            return false;
        }
        table[index] = null;
        size--;
        modCount++;
        return true;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int point = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                while (point < capacity && table[point] == null) {
                    point++;
                }
                return point < capacity;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return table[point++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
