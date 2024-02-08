package com.leetcode.easy;

public class PalindromeNumber {

    /**
     * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backwards as forward
     *
     * Example 1:
     *      Input: 121
     *      Output: true
     *
     * Example 2:
     *      Input: -121
     *      Output: false
     *      Explanation: -121 becomes 121- so it's not a palindrome
     *
     * Example 3:
     *      Input: 10
     *      Output: false
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;

        int copy = x;
        int reversed = 0;

        while (copy > 0) {
            reversed*=10;
            int mod = copy%10;
            reversed+=mod;
            copy/=10;
        }

        return x == reversed;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(123)); // false
        System.out.println(isPalindrome(1232)); // false
        System.out.println(isPalindrome(12321)); // true
        System.out.println(isPalindrome(123321)); // true
    }
}
