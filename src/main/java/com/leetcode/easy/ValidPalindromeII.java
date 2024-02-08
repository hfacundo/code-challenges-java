package com.leetcode.easy;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you
 * can make it a palindrome
 *
 * Example 1:
 *  Input: "aba"
 *  Output: true
 *
 * Example 2:
 *  Input: "abca"
 *  Output: true
 *  Explanation: You could delete the character 'c'
 *
 *  Note: The string will only contain lower case characters a-z
 */
public class ValidPalindromeII {

    public static boolean validPalindromeEnhanced(String s) {
        int from = 0;
        int to = s.length()-1;
        int removed = 0;

        while (from <= to) {
            if (s.charAt(from) != s.charAt(to)) {
                if (removed > 0)
                    return false;
                if (from+1 <= to && s.charAt(from+1) == s.charAt(to)) {
                    from++;
                    removed++;
                } else if (to-1 >= from && s.charAt(from) == s.charAt(to-1)) {
                    to--;
                    removed++;
                } else {
                    return false;
                }
            } else {
                // they are equal
                from++;
                to--;
            }
        }
        return true;
    }

    // ab
    // abb
    // abcdedcbaz
    // abcdedcbza
    // abcdedcba
    public static boolean validPalindrome(String s) {
        for (int x=0; x<s.length()-1; x++) {
            String sub = s.substring(0, x).concat(s.substring(x+1));
            if (isPalindrome(sub))
                return true;
        }
        return false;
    }

    public static boolean isPalindrome(String s) {
        int from = 0;
        int to = s.length()-1;

        while (from <= to) {
            if (s.charAt(from) != s.charAt(to))
                return false;
            from++;
            to--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindromeEnhanced("abcdedcbza")); // true
        System.out.println(validPalindromeEnhanced("abcdedcba")); // true
        System.out.println(validPalindromeEnhanced("abc")); // false
        System.out.println(validPalindromeEnhanced("aba")); // true
        System.out.println(validPalindromeEnhanced("ab")); // true
    }

}
