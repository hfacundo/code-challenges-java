package com.geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Given an array of N integers, and a number sum, the task is to find the number of pairs of integers in the array whose sum is equal to sum.
 *
 * Examples:
 *
 * Input:  arr[] = {1, 5, 7, -1}, sum = 6
 * Output:  2
 * Explanation: Pairs with sum 6 are (1, 5) and (7, -1).
 *
 * Input:  arr[] = {1, 5, 7, -1, 5}, sum = 6
 * Output:  3
 * Explanation: Pairs with sum 6 are (1, 5), (7, -1) & (1, 5).
 *
 * Input:  arr[] = {1, 1, 1, 1}, sum = 2
 * Output:  6
 * Explanation: Pairs with sum 2 are (1, 1), (1, 1), (1, 1), (1, 1), (1, 1).
 *
 * Input:  arr[] = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1}, sum = 11
 * Output:  9
 * Explanation: Pairs with sum 11 are (10, 1), (10, 1), (10, 1), (12, -1), (10, 1), (10, 1), (10, 1), (7, 4), (6, 5).
 */
public class CountPairGivenSum {

    // arr[] = {1, 5, 7, -1}, sum = 6
    public static int countPairs(int[] array, int sum) {
        int count = 0;

        for (int i=0; i<array.length; i++) {
            int numberToFind = sum - array[i];
            count+=countOccurrences(array, i, numberToFind);
        }

        return count;
    }

    public static int countOccurrences(int[] array, int index, int numberToFind) {
        int count = 0;
        for (int i=index+1; i<array.length; i++) {
            if (array[i] == numberToFind)
                count++;
        }
        return count;
    }

    // arr[] = {1, 5, 7, -1}, sum = 6
    public static int countPairsEnhanced(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Store counts of all elements in a map
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int num : arr) {
            int diff = sum - num;
            if (map.containsKey(diff))
                count += map.get(diff);

            // if (arr[i], arr[i]) pair satisfies the
            // condition, then we need to ensure that the
            // count is decreased by one such that the
            // (arr[i], arr[i]) pair is not considered
            if (diff == num)
                count--;
        }

        // return the half of twice_count
        return count / 2;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 7, -1};
        System.out.println(countPairsEnhanced(array, 6)); // 2

        array = new int[]{1, 5, 7, -1, 5};
        System.out.println(countPairsEnhanced(array, 6)); // 3

        array = new int[]{1, 1, 1, 1};
        System.out.println(countPairsEnhanced(array, 2)); // 6

        array = new int[]{10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
        System.out.println(countPairsEnhanced(array, 11)); // 9

    }

}
