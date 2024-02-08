package com.leetcode.easy;

import java.util.Arrays;

public class ReverseString {

    /**
     * Write a function that reverses a string. The input string is given as an array of characters char[]
     *
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory
     *
     * Example 1:
     *  Input: ["h", "e", "l", "l", "o"]
     *  Output: ["o", "l", "l", "e", "h"]
     *
     * @param s
     */
    public static void reverseString(char[] s) {
        int from = 0;
        int to = s.length-1;

        while (from < to) {
            char temp = s[from];
            s[from] = s[to];
            s[to] = temp;
            from++;
            to--;
        }

        for (int x=0; x<s.length; x++) {
            System.out.print(s[x]);
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
    }
}
