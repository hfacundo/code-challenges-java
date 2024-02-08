package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Given n pair of parentheses, write a function to generate all combinations of
 * well-formed parentheses.
 *
 * For example, given n=3, a solution set is
 * [
 *      "((()))",
 *      "(()())",
 *      "(())()",
 *      "()(())",
 *      "()()()"
 * ]
 */
public class GenerateParentheses {

    public static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        generateRecursive(result, "", 0, 0, n);
        return result;
    }

    public static void generateRecursive(List<String> result, String combination, int open, int close, int n) {
        if (combination.length() == n*2) {
            result.add(combination);
            return;
        }

        if (open < n) {
            generateRecursive(result, combination.concat("("), open+1, close, n);
        }
        if (close < open) {
            generateRecursive(result, combination.concat(")"), open, close+1, n);
        }
    }

    /*
        [
           "((()))",
           "(()())",
           "(())()",
           "()(())",
           "()()()"
        ]
     */
    public static List<String> generateParenthesesNoRecursion(int n) {
        List<String> result = new ArrayList<>();
        final char OPEN_PARENTHESES = '(';
        final char CLOSE_PARENTHESES = ')';

        Stack<String> stack = new Stack<>();
        stack.add("");

        while (!stack.isEmpty()) {
            String current = stack.pop();
            int open = countChar(current, OPEN_PARENTHESES);
            int close = countChar(current, CLOSE_PARENTHESES);
            if (open == n && close == n)
                result.add(current);
            if (open < n)
                stack.push(current+OPEN_PARENTHESES);
            if (close < open)
                stack.push(current+CLOSE_PARENTHESES);
        }

        return result;
    }

    public static int countChar(String word, char c) {
        int count = 0;
        for (int i=0; i<word.length(); i++) {
            if (word.charAt(i) == c)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        //System.out.println(generateParentheses(3));
        System.out.println(generateParenthesesNoRecursion(3));
    }
}
