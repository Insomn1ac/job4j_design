package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        if (value != null && !value.toString().isEmpty()) {
            SoftReference<V> softVal = new SoftReference<>(value);
            cache.put(key, softVal);
        } else {
            System.out.println("Enter a valid filename");
        }
    }

    public V get(K key) {
        V rsl = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (!cache.containsKey(key) || rsl == null) {
            rsl = load(key);
            put(key, rsl);
        }
        return rsl;
    }

    protected abstract V load(K key);
}
