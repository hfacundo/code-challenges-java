package com.challenge;

import java.util.*;

public class LinkedListExample {

    public static void reverseLinkedListExample() {
        List<String> linkedList = new LinkedList<>();
        linkedList.add("bb");
        linkedList.add("dd");
        linkedList.add("aa");
        linkedList.add("cc");
        linkedList.add("xx");
        System.out.println(linkedList);

        List<String> reversedLinkedList = new LinkedList<>();

        for (int i=linkedList.size()-1; i>=0; i--) {
            reversedLinkedList.add(linkedList.get(i));
        }

        System.out.println(reversedLinkedList);

    }

    public static void main(String[] args) {
        reverseLinkedListExample();
        Set<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(3);
        System.out.println(set.stream().min(Comparator.comparingInt(o -> o)));
    }

}
