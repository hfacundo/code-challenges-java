package com.leetcode.medium;

import java.util.Set;
import java.util.TreeSet;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *  Input: s = "abcabcbb"
 *  Output: 3
 *  Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *  Input: s = "bbbbb"
 *  Output: 1
 *  Explanation: The answer is "b", with the length of 1
 */
public class LongestSubstring {

    public static int findLongestSubstring(String s) {
        int longest = 0;
        Set<Character> set = new TreeSet<>();
        int count = 1;

        for (int x=0; x<s.length(); x++) {
            set.add(s.charAt(x));
            int from = x+1;
            while (from < s.length()) {
                if (!set.contains(s.charAt(from))) {
                    set.add(s.charAt(from));
                    count++;
                    from++;
                } else {
                    longest = Math.max(longest, count);
                    count = 1;
                    set.clear();
                    break;
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println(findLongestSubstring("abcabcbb")); // 3
    }
}
