package com.geeksforgeeks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays A[] and B[] of size n. It is given that both array individually contains distinct elements. We need to find the sum of all elements that are not common.
 *
 * Examples:
 *
 * Input : A[] = {1, 5, 3, 8}
 *         B[] = {5, 4, 6, 7}
 * Output : 29
 * 1 + 3 + 4 + 6 + 7 + 8 = 29
 *
 * Input : A[] = {1, 5, 3, 8}
 *         B[] = {5, 1, 8, 3}
 * Output : 0
 * All elements are common.
 */
public class NoOverlappingSum {

    public static int sumNoOverlappedElements(int[] array1, int[] array2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : array1) {
            set1.add(num);
        }

        for (int num : array2) {
            set2.add(num);
        }

        int sum = getCount(set1, array2) + getCount(set2, array1);
        return sum;
    }

    public static int getCount(Set<Integer> set, int[] array) {
        int sum = 0;
        for (int num : array) {
            if (!set.contains(num))
                sum+=num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 5, 3, 8};
        int[] array2 = {5, 4, 6, 7};
        System.out.println(sumNoOverlappedElements(array1, array2)); // 29

        array1 = new int[] {1, 5, 3, 8};
        array2 = new int[] {5, 1, 8, 3};
        System.out.println(sumNoOverlappedElements(array1, array2)); // 0
    }

}
