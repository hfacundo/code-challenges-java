package com.geeksforgeeks;

import java.util.Arrays;

/**
 * Given two sets represented by two arrays, how to check if the given two sets are disjoint or not? It may be assumed that the given arrays have no duplicates.
 *
 * Input: set1[] = {12, 34, 11, 9, 3}
 *        set2[] = {2, 1, 3, 5}
 * Output: Not Disjoint
 * 3 is common in two sets.
 *
 * Input: set1[] = {12, 34, 11, 9, 3}
 *        set2[] = {7, 2, 1, 5}
 * Output: Yes, Disjoint
 * There is no common element in two sets.
 */
public class CheckTwoSetsDisjoint {

    public static boolean checkDisjoint(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);

        int i = 0;
        int j = 0;

        while (i < array1.length && j < array2.length) {
            int element1 = array1[i];
            int element2 = array2[j];
            if (element1 == element2)
                return false;
            else if (element1 < element2)
                i++;
            else // element1 > element2
                j++;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] array1 = {12, 34, 11, 9, 3};
        int[] array2 = {2, 1, 3, 5};
        System.out.println(checkDisjoint(array1, array2)); // false

        array1 = new int[] {12, 34, 11, 9, 3};
        array2 = new int[] {7, 2, 1, 5};
        System.out.println(checkDisjoint(array1, array2)); // true
    }

}
