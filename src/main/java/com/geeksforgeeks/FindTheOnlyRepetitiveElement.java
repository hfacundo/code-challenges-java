package com.geeksforgeeks;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of size N filled with numbers from 1 to N-1 in random order. The array has only one repetitive element. The task is to find the repetitive element.
 *
 * Examples:
 *
 * Input: a[] = {1, 3, 2, 3, 4}
 * Output: 3
 * Explanation: The number 3 is the only repeating element.
 *
 * Input: a[] = {1, 5, 1, 2, 3, 4}
 * Output: 1
 */
public class FindTheOnlyRepetitiveElement {

    public static int findTheMostRepetitive(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int element : array) {
            if (!set.contains(element))
                set.add(element);
            else
                return element;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 3, 4};
        System.out.println(findTheMostRepetitive(array)); // 3

        int[] array2 = {1, 5, 1, 2, 3, 4};
        System.out.println(findTheMostRepetitive(array2)); // 1
    }

}
