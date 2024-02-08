package com.leetcode.easy;

public class ValidPalindrome {

    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     *
     * Note: For the purpose of this problem, we define empty string as a valid palindrome
     *
     * Example 1:
     *  Input: "A man, a plan, a canal: Panama"
     *  Output: true
     *
     * Example 2:
     *  Input: "race a car"
     *  Output: false
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        StringBuilder b = new StringBuilder();

        for (int x=0; x<s.length(); x++) {
            if (Character.isLetter(s.charAt(x))) {
                if (Character.isUpperCase(s.charAt(x)))
                    b.append((char) (s.charAt(x) + 32));
                else
                    b.append(s.charAt(x));
            }
        }

        int from = 0;
        int to = b.length()-1;

        while (from < b.length()) {
            if (b.charAt(from) != b.charAt(to))
                return false;
            from++;
            to--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car")); // false
    }
}
