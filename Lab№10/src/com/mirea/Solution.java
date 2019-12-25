package com.mirea;

import java.util.*;

public class Solution {
    @SafeVarargs
    static <T> ArrayList<T> newArrayList(T... args) {
        return new ArrayList<>(Arrays.asList(args));
    }

    @SafeVarargs
    static <T> HashSet<T> newHashSet(T... args) {
        return new HashSet<>(Arrays.asList(args));
    }

    @SafeVarargs
    static <K, V> HashMap<K, V> newHashMap(AbstractMap.SimpleEntry<K, V>... args) {
        HashMap<K, V> hashMap = new HashMap<>();

        for(AbstractMap.SimpleEntry<K, V> entry : args) {
            hashMap.put(entry.getKey(), entry.getValue());
        }

        return hashMap;
    }

    static class Pair<K, V> extends AbstractMap.SimpleEntry<K, V> {
        public Pair(K key, V value) {
            super(key, value);
        }
    }
}
