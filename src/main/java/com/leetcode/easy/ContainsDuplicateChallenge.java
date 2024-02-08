package com.leetcode.easy;

import java.util.Set;
import java.util.TreeSet;

public class ContainsDuplicateChallenge {

    /**
     * Given an array of integers, find if the array contains any duplicates
     *
     * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
     *
     * Example 1:
     *
     * Input: [1, 2, 3, 1]
     * Output: true
     *
     * Example 2:
     *
     * Input: [1, 2, 3, 4]
     * Output: false
     *
     * Example 3:
     *
     * Input: [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
     * Output: true
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> elements = new TreeSet<>();
        for (int n : nums) {
            if (elements.contains(n))
                return true;
            else
                elements.add(n);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(nums1)); // should return true
        System.out.println(containsDuplicate(nums2)); // should return false
        System.out.println(containsDuplicate(nums3)); // should return true
    }

}
