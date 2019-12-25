package com.mirea;

import java.util.ArrayList;

public class HashTable<K, V> {
    private ArrayList<LinkedListNode<K, V>> arr;

    public HashTable(int capacity) {
        arr = new ArrayList<>(capacity);
        arr.ensureCapacity(capacity);
        for (int i = 0; i < capacity; i++) {
            arr.add(null);
        }
    }

    private static class LinkedListNode<K, V> {
        private LinkedListNode<K, V> next;
        private LinkedListNode<K, V> prev;
        private Double key;
        private V value;

        private LinkedListNode(Double k, V v) {
            key = k;
            value = v;
        }

        private String printForward() {
            String data = "(" + key + "," + value + ")";
            if (next != null) {
                return data + "->" + next.printForward();
            } else {
                return data;
            }
        }
    }

    public void put(Double key, V value) {
        LinkedListNode<K, V> node = new LinkedListNode<>(key, value);

        int index = getIndexForKey(key);
        if (arr.get(index) != null) {
            node.next = arr.get(index);
            node.next.prev = node;
        }
        arr.set(index, node);
    }

    public V remove(Double key) {
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node == null) {
            return null;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            int hashKey = getIndexForKey(key);
            arr.set(hashKey, node.next);
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }
        return node.value;
    }

    public V get(Double key) {
        if (key == null) return null;
        LinkedListNode<K, V> node = getNodeForKey(key);

        return node == null ? null : node.value;
    }

    private LinkedListNode<K, V> getNodeForKey(Double key) {
        int index = getIndexForKey(key);
        LinkedListNode<K, V> current = arr.get(index);

        while (current != null) {
            if (equalDouble(current.key, key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private int getIndexForKey(Double key) {
        return Math.abs(key.hashCode() % arr.size());
    }

    public void printTable() {
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i) == null ? "" : arr.get(i).printForward();
            System.out.println(i + ": " + s);
        }
    }

    private boolean equalDouble(Double a, Double b) {
        double diff = Math.abs(a - b);
        double largest = Math.max(b, a);

        return diff <= largest * 1e-5;
    }
}
