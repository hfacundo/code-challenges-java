package com.leetcode.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSumII {

    /**
     * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number
     *
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index 2.
     *
     * Note:
     *  Your returned answer (both index1 and index2) are not zero-based
     *  You may assume that each input would have exactly one solution and you may not use the same element twice
     *
     *  Example:
     *
     *  Input: numbers = [2, 7, 11, 15], target: 9
     *  Output: [1, 2]
     *  Explanation: The sum of 2 and 7 is 9, Therefore index1 = 1, index2 = 2;
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        for (int x=0; x<numbers.length; x++) {
            int current = numbers[x];
            for (int y=x+1; y<numbers.length; y++) {
                if (current + numbers[y] == target) {
                    result[0] = x+1;
                    result[1] = y+1;
                    return result;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int[] result = twoSum(numbers, 9);
        System.out.println("[" + result[0] + ", " + result[1] + "]");

    }
}
