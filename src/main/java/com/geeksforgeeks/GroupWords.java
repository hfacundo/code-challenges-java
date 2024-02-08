package com.geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
    Given a list of words with lower cases. Implement a function to find all Words that have the same unique character set.

    Example:

    Input: words[] = { "may", "student", "students", "dog",
                     "studentssess", "god", "cat", "act",
                     "tab", "bat", "flow", "wolf", "lambs",
                     "amy", "yam", "balms", "looped",
                     "poodle"};
    Output :
    looped, poodle,
    lambs, balms,
    flow, wolf,
    tab, bat,
    may, amy, yam,
    student, students, studentssess,
    dog, god,
    cat, act,

    All words with same set of characters are printed
    together in a line.
 */
public class GroupWords {

    public static void printGroup(String[] words) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            Set<Character> set = new TreeSet<>();
            for (int i=0; i<word.length(); i++) {
                set.add(word.charAt(i));
            }
            String key = set.toString();
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", values: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String[] words = { "may", "student", "students", "dog",
                "studentssess", "god", "cat", "act",
                "tab", "bat", "flow", "wolf", "lambs",
                "amy", "yam", "balms", "looped",
                "poodle"};
        printGroup(words);

    }
}
