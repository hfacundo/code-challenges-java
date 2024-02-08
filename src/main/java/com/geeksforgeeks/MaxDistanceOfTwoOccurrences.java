package com.geeksforgeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array with repeated elements, the task is to find the maximum distance between two occurrences of an element.
 *
 * Examples:
 *
 * Input : arr[] = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2}
 * Output: 10
 * // maximum distance for 2 is 11-1 = 10
 * // maximum distance for 1 is 4-2 = 2
 * // maximum distance for 4 is 10-5 = 5
 */
public class MaxDistanceOfTwoOccurrences {

    public static int calculateMaximumDistance(int[] array) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        int i = 0;
        for (int num : array) {
            map.putIfAbsent(num, new ArrayList<>());
            map.get(num).add(i);
            i++;
        }

        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {

            if (entry.getValue().size() >= 2) {
                int distance = getMaximumDistance(entry.getValue());
                max = Math.max(max, distance);
            }
        }

        return max;
    }

    public static int getMaximumDistance(List<Integer> list) {
        return Math.abs(list.get(0) - list.get(list.size()-1));
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
        System.out.println(calculateMaximumDistance(array));
    }

}
