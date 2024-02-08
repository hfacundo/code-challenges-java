package com.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParenthesisNoRecursion {

    private List<String> combinations = new ArrayList<>();
    private final String OPEN = "(";
    private final String CLOSE = ")";

    public List<String> generateCombinations(String result, int open, int close, int n) {
        System.out.println("Result: " + result + ", open: " + open + ", close: " + close);
        if (open + close == n*2) {
            combinations.add(result);
        } else {
            if (open < n) {
                // System.out.println(result + "(");
                generateCombinations(result.concat(OPEN), open+1, close, n);
            }
            if (close < open) {
                // System.out.println(result + ")");
                generateCombinations(result.concat(CLOSE), open, close+1, n);
            }
        }
        return combinations;
    }

    // validate parentheses are valid
    // ex: (s(99)s) is valid
    //     (i))1(22) is invalid
    // (2)(22)(3)(()) is valid
    // valid when every open has a close parentheses
    public boolean isParenthesesValid(String input) {
        Stack<Character> stack = new Stack<>();
        for (int x=0; x<input.length(); x++) {
            if (input.charAt(x) == '(') {
                stack.add(input.charAt(x));
            } else if (input.charAt(x) == ')') {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public List<String> generateCombinationsNoRecursion(int n) {
        List<String> result = new ArrayList<>();
        String OPEN = "(";
        String CLOSE = ")";
        // n=3
        // ()()() ((())) (()()) ()(()) (())()

        StringBuilder b = new StringBuilder();
        int open = 0;
        int close = 0;

        while (open < n) {
            b.append(OPEN);
            open++;
            int temp = open;
            if (close < open) {
                while (close < open) {
                    b.append(CLOSE);
                    close++;
                }
            } else if (open < n) {
                while (open < n) {
                    b.append(OPEN);
                    open++;
                }
            }
            open = temp;
            close = 0;
        }


        return result;
    }

    public static void main(String[] args) {
        ParenthesisNoRecursion p = new ParenthesisNoRecursion();
        // List<String> combinations = p.generateCombinations("", 0, 0, 3);
        // System.out.println(combinations);
        System.out.println(p.isParenthesesValid("(s(99)s)"));
        System.out.println(p.isParenthesesValid("(i))1(22)"));
        System.out.println(p.isParenthesesValid("(2)(22)(3)(())"));
        System.out.println(p.isParenthesesValid("()"));
    }

}
