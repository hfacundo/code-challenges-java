package com.leetcode.easy;

public class BackspaceStringCompare {

    /**
     * Given two strings S and T, return if they are equal when both are typed into empty text editors.
     * -> # means a backspace character
     *
     * Example1:
     *  Input: s = "ab#c", t = "ad#c"
     *  Output: true
     *  Explanation: Both s and t become "ac"
     *
     * Example 2:
     *  Input: s = "ab##", t = "c#d#"
     *  Output: true
     *  Explanation: both s and t become ""
     *
     * Example 3:
     *  Input: "a#c", t = "b"
     *  Output: false
     *  Explanation: s becomes "c" while t becomes "b"
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean backspaceCompare(String s, String t) {
        return processString(s).equals(processString(t));
    }

    private static String processString(String s) {
        StringBuilder sb = new StringBuilder();

        for (int x = 0; x<s.length(); x++) {
            if (s.charAt(x) == '#') {
                if (sb.length() > 0)
                    sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(s.charAt(x));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(backspaceCompare("ab##", "c#d#")); // true
        System.out.println(backspaceCompare("a#c", "b")); // false
    }
}
