package com.leetcode.easy;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class SquaresOfSortedArray {

    /**
     * Given an array of integers A sorted in non-decreasing order, return an array of the squares
     * of each number, also in sorted non-decreasing order
     *
     * Example 1:
     *  Input: [-4, -1, 0, 3, 10]
     *  Output: [0, 1, 9, 16, 100]
     *
     * Explanation:
     *  -4^2 = 16
     *  -1^2 = 1
     *  0^2 = 0
     *  3^2 = 9
     *  10^2 = 100
     *
     */
    public static int[] sortedSquares(int[] a) {

        Set<Integer> set = new TreeSet<>();
        int[] result = new int[a.length];

        for (int x=0; x<a.length; x++) {
            set.add(a[x] * a[x]);
        }

        int i = 0;
        for (Integer num : set) {
            result[i] = num;
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] result = sortedSquares(nums); // [0, 1, 9, 16, 100]
        Arrays.stream(result).boxed().forEach(System.out::println);
    }
}
