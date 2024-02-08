package com.leetcode.easy;

/**
 * Given a string s, return the reversed string where all characters that are not a letter stay
 * in the same place, and all letters reverse their positions
 *
 * Example 1:
 *  Input: "ab-cd"
 *  Output: "dc-ba"
 *
 * Example 2:
 *  Input: "a-bC-dEf-ghIj"
 *  Output: "j-Ih-gfE-dCba"
 */
public class ReverseOnlyLetters {

    public static String reverseOnlyLetters(String s) {
        char[] arrayOfChars = new char[s.length()];

        int left = 0;
        int right = s.length()-1;

        while (left <= right) {
            if (Character.isLetter(s.charAt(left)) && Character.isLetter(s.charAt(right))) {
                char temp = s.charAt(left);
                arrayOfChars[left] = s.charAt(right);
                arrayOfChars[right] = temp;
                left++;
                right--;
            } else if (!Character.isLetter(left)) {
                arrayOfChars[left] = s.charAt(left);
                left++;
            } else if (!Character.isLetter(right)) {
                arrayOfChars[right] = s.charAt(right);
                right--;
            }
        }

        return new String(arrayOfChars);
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd")); // dc-ba
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj")); // "j-Ih-gfE-dCba"
    }
}
