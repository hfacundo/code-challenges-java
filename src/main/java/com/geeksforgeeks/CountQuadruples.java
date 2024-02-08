package com.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

/*
    Given four sorted arrays each of size n of distinct elements. Given a value x. The problem is to count all quadruples(group of four numbers)
    from all the four arrays whose sum is equal to x.
    Note: The quadruple has an element from each of the four arrays.

    Examples:

    Input : arr1 = {1, 4, 5, 6},
            arr2 = {2, 3, 7, 8},
            arr3 = {1, 4, 6, 10},
            arr4 = {2, 4, 7, 8}
            n = 4, x = 30
    Output : 4
    The quadruples are:
    (4, 8, 10, 8), (5, 7, 10, 8),
    (5, 8, 10, 7), (6, 7, 10, 7)

    Input : For the same above given fours arrays
            x = 25
    Output : 14
 */
public class CountQuadruples {

    public static int count(int[] arr1, int[] arr2, int[] arr3, int[] arr4, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr1.length; i++) {
            for (int j=0; j<arr2.length; j++) {
                int num = arr1[i] + arr2[j];
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int result = 0;
        for (int k=0; k<arr3.length; k++) {
            for (int l=0; l<arr4.length; l++) {
                int num = arr3[k] + arr4[l];
                int diff = x - num;
                if (map.containsKey(diff))
                    result+=map.get(diff);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5, 6};
        int[] arr2 = {2, 3, 7, 8};
        int[] arr3 = {1, 4, 6, 10};
        int[] arr4 = {2, 4, 7, 8};

        System.out.println(count(arr1, arr2, arr3, arr4, 30)); // 4
        System.out.println(count(arr1, arr2, arr3, arr4, 25)); // 14
    }

}
