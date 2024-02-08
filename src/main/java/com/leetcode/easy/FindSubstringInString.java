package com.leetcode.easy;

/**
 * Given a String s, and a String sub, count how many times sub exist in s
 *
 * Example 1:
 *  Input: s = "Banana", sub = "ana"
 *  Output: 1
 *
 * Example 2:
 *  Input: s = "Banapana", sub = "ana"
 *  Output: 2
 */
public class FindSubstringInString {

    public static int findOccurrences(String s, String sub) {
        if (s.length() < sub.length())
            return 0;

        int count = 0;
        int index = 0;

        while (index != -1) {
            index = s.indexOf(sub);
            if (index == -1)
                break;
            count++;
            s = s.substring(index+sub.length());
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(findOccurrences("Banana", "ana")); // 1
        System.out.println(findOccurrences("Banapana", "ana")); // 2
    }
}
