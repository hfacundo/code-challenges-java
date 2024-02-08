package com.geeksforgeeks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array A[] of n numbers and another number x, the task is to check whether or not there exist two elements in A[] whose sum is exactly x.
 *
 * Examples:
 *
 * Input: arr[] = {0, -1, 2, -3, 1}, x= -2
 * Output: Yes
 * Explanation:  If we calculate the sum of the output,1 + (-3) = -2
 *
 * Input: arr[] = {1, -2, 1, 0, 5}, x = 0
 * Output: No
 */
public class CheckPairGivenSum {

    public static boolean checkPair(int[] array, int x) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] == x) {
                return true;
            }
            if (array[left] + array[right] > x) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {0, -1, 2, -3, 1};
        System.out.println(checkPair(array, -2)); // true

        int[] array2 = {1, -2, 1, 0, 5};
        System.out.println(checkPair(array2, 0)); // false
    }

}
