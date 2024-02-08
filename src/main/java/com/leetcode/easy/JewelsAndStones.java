package com.leetcode.easy;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * You're given strings j representing the types of stones that are jewels, and s representing
 * the stones you have. Each character in s is a type of stone you have. You want to know
 * how many of the stones you have are also jewels.
 *
 * The letters in j are guaranteed distinct, and all characters in j and s are letters. Letters
 * are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *  Input: j="aA", s = "aAAbbbb"
 *  Output: 3
 *  Explanation: "a" and "A" (from j) are jewels so you have aAAbbb which means, you have "a" and "AA" so you have 3 jewels
 *  the result is 3
 *
 * Example 2:
 *  Input: j = "z", s = "ZZ"
 *  Output: 0
 *
 *
 */
public class JewelsAndStones {

    public static int numJewelsInStones(String j, String s) {
        int count = 0;
        for (int x=0; x<s.length(); x++) {
            if (j.contains(String.valueOf(s.charAt(x)))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

}
