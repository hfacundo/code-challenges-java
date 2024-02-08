package com.leetcode.medium;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of
 * contiguous a subarray of which the sum >= s, if there isn't one, return 0 instead.
 *
 * Example:
 *
 *  Input: s=7, nums = [2, 3, 1, 2, 4, 3]
 *  Output: 2
 *  Explanation: the subarray [4, 3] has the minimal length under the problem constraint
 *
 *  Note: Contiguous means select elements next to each other, no sort allowed
 *
 */
public class MinimumSizeSubArray {

    public static int minSubArrayLen(int s, int[] nums) {
        int from = 0;
        int min = Integer.MAX_VALUE;

        while (from < nums.length) {
            if (nums[from] >= s)
                return 1;
            int sum = nums[from];
            int count = 1;
            for (int x=from+1; x<nums.length; x++) {
                sum+=nums[x];
                count++;
                if (sum >= s) {
                    min = Math.min(min, count);
                    break;
                }
            }
            from++;
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
        System.out.println(minSubArrayLen(9, nums));
        System.out.println(minSubArrayLen(25, nums));
    }
}
