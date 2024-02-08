package com.leetcode.medium;

/**
 * Given two sorted arrays nums1 and nums 2 of size m and n respectively, return the median
 * of the two sorted arrays
 *
 * Example 1:
 *  Input: nums1 = {1, 3}, nums 2 = {2}
 *  Output: 2.00000
 *  Explanation: merged array = {1, 2, 3} and median is 2
 */
public class MedianTwoSortedArrays {

    public static int medianOfTwoSortedArrays(int[] nums1, int[] nums2) {
        int middle = (nums1.length + nums2.length) / 2;
        int index1 = 0;
        int index2 = 0;
        int count = 0;

        while (count < middle) {
            int num1 = nums1[index1];
            int num2 = nums2[index2];
            if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
            count++;
            if (count == middle)
                return Math.max(num1, num2);
        }

        return 0;
    }

    public static void main(String[] args) {
        // 1, 2, 3, 4, 5, 6, 7, 8, 9 -> middle 5
        int[] nums1 = {1, 4, 6, 8};
        int[] nums2 = {2, 3, 5, 7, 9};
        System.out.println(medianOfTwoSortedArrays(nums1, nums2));

    }
}
