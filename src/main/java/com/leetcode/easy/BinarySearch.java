package com.leetcode.easy;

public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        if (nums.length == 0)
            return -1;

        int from = 0;
        int to = nums.length-1;
        int limit = 0; // in case of an infinite loop

        while (from <= to && limit < nums.length) {
            int mid = from + (to - from) / 2;
            System.out.println("mid: " + mid);
            if (nums[mid] == target) {
                System.out.println("found it " + mid);
                return mid;
            } else if (nums[mid] < target) {
                System.out.println("nums[mid] < target ");
                from = mid;
            } else { // greater than target
                System.out.println("nums[mid] > target ");
                to = mid;
            }
            limit++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 6;
        System.out.println(binarySearch(nums, target));
        System.out.println(binarySearch(nums, 2));
    }

}
