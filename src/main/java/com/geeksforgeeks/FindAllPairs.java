package com.geeksforgeeks;

/*
    Given an array with distinct elements, the task is to find the pairs in the array such that a % b = k, where k is a given integer.

    Examples :

    Input  :  arr[] = {2, 3, 5, 4, 7}
                  k = 3
    Output :  (7, 4), (3, 4), (3, 5), (3, 7)
    7 % 4 = 3
    3 % 4 = 3
    3 % 5 = 3
    3 % 7 = 3
 */
public class FindAllPairs {

    public static void printPairs(int[] arr, int k) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j< arr.length; j++) {
                if (i != j && arr[i] % arr[j] == k)
                    System.out.println(arr[i] + ", " + arr[j]);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 4, 7};
        printPairs(arr, 3);
    }
}
