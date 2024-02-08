package com.geeksforgeeks;

/*
    Given two strings S and T of equal length. Both strings contain only the characters ‘0’ and ‘1’.
    The task is to find the minimum number of operations to convert string S to T. There are 2 types of operations allowed on string S:

    Swap any two characters of the string.
    Replace a ‘0’ with a ‘1’ or vice versa.
    Examples:

    Input: S = “011”, T = “101”
    Output: 1
    Swap the first and second character.

    Input: S = “010”, T = “101”
    Output: 2
    Swap the first and second character and replace the third character with '1'.
 */
public class MinOperationsString {

    public static int findMinimumOperations(String s, String t) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findMinimumOperations("011", "101")); // 1
        System.out.println(findMinimumOperations("010", "101")); // 2
        System.out.println(findMinimumOperations("00110", "11101")); // 2
    }

}
