package com.leetcode.medium;

import java.util.Arrays;

public class SumClosest {

    /**
     * Given an array nums of n integers and an integer target, find three integers in nums
     * such that the sum is closes to target. Return the sum of the three integers. You
     * may assume that each input would have exactly one solution.
     *
     * Example:
     *
     *  Given array nums = [-1, 2, 1, -4], and target = 1
     *  The sum that is closes to the target is 2. (-1 + 2 + 1 = 2).
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(target-result);

        // -4 -1 1 2
        for (int x=0; x<nums.length-2; x++) {
            int sum = nums[x] + nums[x+1] + nums[x+2];
            int d = Math.abs(target-sum);
            if (d < diff) {
                result = sum;
                diff = d;
            } else if (d > diff)
                return sum;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));

        /*
        int[] sorted = {-4, -1, 1, 2};
        System.out.println(sorted[0] + sorted[1] + sorted[2]);
        System.out.println(sorted[1] + sorted[2] + sorted[3]);
        int target = 1;
        int sum = sorted[0] + sorted[1] + sorted[2];

        System.out.println(Math.abs(target-sum));

         */
    }
}
