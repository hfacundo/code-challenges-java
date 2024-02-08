package com.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array, find the most frequent element in it. If there are multiple elements that appear a maximum number of times, print any one of them.
 *
 * Examples:
 *
 * Input : arr[] = {1, 3, 2, 1, 4, 1}
 * Output : 1
 * Explanation: 1 appears three times in array which is maximum frequency.
 *
 * Input : arr[] = {10, 20, 10, 20, 30, 20, 20}
 * Output : 20
 */
public class MostFrequentElement {

    public static int findMostFrequent(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int number = Integer.MIN_VALUE;
        int occurrences = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > occurrences) {
                number = entry.getKey();
                occurrences = entry.getValue();
            }
        }

        return number;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 1, 4, 1};
        System.out.println(findMostFrequent(array)); // 1

        int[] array2 = {10, 20, 10, 20, 30, 20, 20};
        System.out.println(findMostFrequent(array2)); // 20
    }
}
