package com.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParenthesisRefactored {

    private final String OPEN = "(";
    private final String CLOSE = ")";
    List<String> combinations = new ArrayList<>();

    // Below function recursively generates strings with balanced parenthesis.
    public List<String> generateCombinations (String result, int open, int close, int n) {

        // If the sum of the opening and closing parenthesis is same as the number of pairs,
        // then we have got a valid string.
        if(open + close == 2 * n) {
            combinations.add(result);
        } else {
            if (open < n) {
                generateCombinations (result.concat(OPEN), open + 1, close, n);
            }
            // A closing parenthesis should always come after an opening parenthesis and should always
            // be less than the count of the opening parenthesis already present in the result string
            // before it gets appended.
            if (close < open) {
                generateCombinations (result.concat(CLOSE), open, close + 1, n);
            }
        }
        return combinations;
    }

    public static void main (String [] args) {
        ParenthesisRefactored p = new ParenthesisRefactored();
        int n = 3;
        List<String> combinations = p.generateCombinations("", 0, 0, n);
        System.out.println(combinations);
        //Map<Integer, Integer> numbers = Map.of(1,0, 0,0, -1, 0);
        //numbers.put(1, 1);
        //System.out.println(numbers);
    }
}
