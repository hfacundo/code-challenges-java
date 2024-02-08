package com.challenge;

import java.util.*;

public class MapExample {

    // ordered!!
    // sort elements by ID
    public static void treeMapExample() {
        Map<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(6, 3);
        treeMap.put(5, 7);
        treeMap.put(11, 21);
        treeMap.put(23, 12);
        treeMap.put(1, 5);
        treeMap.put(9, 0);
        treeMap.put(4, 4);
        treeMap.put(7, 22);
        treeMap.put(3, 14);
        treeMap.put(2, 3);
        System.out.println(treeMap);

        Map<Integer, Integer> reversedTreeMap = new TreeMap<>(Collections.reverseOrder());
        reversedTreeMap.putAll(treeMap);
        reversedTreeMap.put(8, 8);
        System.out.println(reversedTreeMap);
    }

    public static void hashMapExample() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(6, 3);
        map.put(5, 7);
        map.put(11, 21);
        map.put(23, 12);
        map.put(1, 5);
        map.put(9, 0);
        map.put(4, 4);
        map.put(7, 22);
        map.put(3, 14);
        map.put(2, 3);
        System.out.println(map);
    }

    public static void linkedHashMapExample() {
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(6, 3);
        linkedHashMap.put(5, 7);
        linkedHashMap.put(11, 21);
        linkedHashMap.put(23, 12);
        linkedHashMap.put(1, 5);
        linkedHashMap.put(9, 0);
        linkedHashMap.put(4, 4);
        linkedHashMap.put(7, 22);
        linkedHashMap.put(3, 14);
        linkedHashMap.put(2, 3);
        System.out.println(linkedHashMap);
    }

    public static void main(String[] args) {
        hashMapExample();
        linkedHashMapExample();
        treeMapExample();
    }

}
