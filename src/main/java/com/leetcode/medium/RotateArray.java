package com.leetcode.medium;

import java.util.Arrays;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative
 *
 * Example 1:
 *  Input: nums = [1, 2, 3, 4, 5, 6, 7], k = 3
 *  Output: [5, 6, 7, 1, 2, 3, 4]
 *  Explanation:
 *      Rotate 1 steps to the right: [7, 1, 2, 3, 4, 5, 6]
 *      Rotate 2 steps to the right: [6, 7, 1, 2, 3, 4, 5]
 *      Rotate 3 steps to the right: [5, 6, 7, 1, 2, 3, 4]
 */
public class RotateArray {

    public static int[] rotateArrayToTheRight(int[] nums, int k) {
        k = k%nums.length;
        if (k == 0)
            return nums;

        int index = k-1;
        int from = nums.length-1;

        int[] result = new int[nums.length];
        for (int x=0; x<nums.length; x++) {
            result[index] = nums[from];
            if (index+1 == nums.length)
                index = 0;
            else
                index++;

            if (from+1 == nums.length)
                from = 0;
            else
                from++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] result = rotateArrayToTheRight(nums, 3);
        System.out.println(Arrays.toString(result));

    }

}
