package com.leetcode.easy;

/**
 * Let's call an array A a mountain if the following properties hold:
 *
 * A.length >= 3
 * elements in array are: A[0] < A[1] ... < A[i-1] < A[i] > A[i+1] > A[i+2]... A[A.length-1]
 *
 * In other words, elements go in ascending order until they reach the peak, then it continues in decreasing order
 *
 * Example 1:
 *  Input: A = [1, 2, 3, 4, 5, 4, 3, 2, 1]
 *  Output: 5
 *
 * Example 2:
 *  Input: A = [1, 4, 7, 23, 8, 4, 3, 1]
 *  Output: 23
 */
public class PeakIndexInMountain {

    public static int peakValueInMountain(int[] a) {
        int index = 0;
        while (a[index] < a[index+1]) {
            index++;
        }
        return a[index];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        System.out.println(peakValueInMountain(a));
        a = new int[]{1, 4, 7, 23, 8, 4, 3, 1};
        System.out.println(peakValueInMountain(a));
    }
}
