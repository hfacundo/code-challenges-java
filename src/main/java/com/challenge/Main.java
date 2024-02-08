package com.challenge;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    /*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    The problem requires you to generate all possible combinations of n pairs of well-formed parentheses.
    A well-formed parentheses combination is defined as one where every opening parenthesis has a corresponding closing parenthesis,
    and the closing parenthesis is not used before its corresponding opening parenthesis.

    For example, for n=2, the valid combinations of well-formed parentheses are "()()", and "(())".
    Test Case 1:
    Input: n = 1
    Expected Output: ["()"]
    Explanation: There is only one pair of parentheses, and there is only one possible combination that is well-formed.

    Test Case 2:
    Input: n = 2
    Expected Output: ["(())", "()()"]
    Explanation: There are two pairs of parentheses, and two possible combinations that are well-formed.

    Test Case 3:
    Input: n = 3
    Expected Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
    Explanation: There are three pairs of parentheses, and five possible combinations

    Test Case 5:
    Input: n = 4
    Expected Output: ["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()",
                        "()((()))","()(()())","()(())()","()()(())","()()()()"]
     */

    private final String OPEN = "(";
    private final String CLOSE = ")";

    public List<String> generateCombinations(int n) {
        List<String> combinations = new ArrayList<>();
        generate(combinations, "", 0, 0, n);
        return combinations;
    }

    public List<String> generate(List<String> combinations, String combination, int open, int close, int n) {
        if (open + close == n * 2)
            combinations.add(combination);
        else {
            if (open < n) {
                generate(combinations, combination.concat(OPEN), open+1, close, n);
            }
            if (close < open) {
                generate(combinations, combination.concat(CLOSE), open, close+1, n);
            }
        }
        return combinations;
    }

    public void plusMinus(List<Integer> arr) {
        Map<Integer, Integer> numbers = new HashMap<>();
        numbers.put(1, 0);
        numbers.put(-1, 0);
        numbers.put(0, 0);

        for (Integer num : arr) {
            if (num == 0) {
                numbers.put(0, numbers.get(0) + 1);
            } else if (num > 0) {
                numbers.put(1, numbers.get(1) + 1);
            } else if (num < 0) {
                numbers.put(-1, numbers.get(-1) + 1);
            }
        }

        BigDecimal size = new BigDecimal(arr.size()).setScale(6);
        BigDecimal ratio1 = new BigDecimal(numbers.get(1)).divide(size, 6, RoundingMode.UP);
        BigDecimal ratioMinus1 = new BigDecimal(numbers.get(-1)).divide(size, 6, RoundingMode.UP);
        BigDecimal ratio0 = new BigDecimal(numbers.get(0)).divide(size, 6, RoundingMode.UP);
        System.out.println(ratio1);
        System.out.println(ratioMinus1);
        System.out.println(ratio0);
    }

    private String testReflection() {
        return "hi";
    }

    /*
        titles = {"Shrek", "Avengers", "Rocky", "Titanic"};
        votes = {"Shrek", "Avengers", "Avengers", "Avengers", "Shrek", "Rocky"};

        print
            Avengers 3
            Shrek 2
            Rocky 1

     */
    private void rank(String[] titles, String[] votes) {
        Map<String, Long> results = Arrays.asList(votes).stream()
                .collect(Collectors.groupingBy(movieName -> movieName, Collectors.counting()));
        List<String> ranking = results.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .map(entry -> entry.getKey().concat(" ").concat(String.valueOf(entry.getValue())))
                .collect(Collectors.toList());
        ranking.forEach(System.out::println);
    }

    private void testPriorityQueue() {

    }

    public void miniMaxSum(List<Integer> arr) {
        Collections.sort(arr);
        long min = arr.subList(0, 4).stream()
                .collect(Collectors.summingLong(Integer::intValue));
        long max = arr.subList(arr.size() - 4, arr.size()).stream()
                .collect(Collectors.summingLong(Integer::intValue));
        System.out.println(min + " " + max);
    }

    public void fizzBuzz(int n) {
        for (int x=1; x<=n; x++) {
            if (n % 3 == 0 && n%5 == 0) {
                System.out.println("FizzBuzz");
            } else if (n%3 == 0) {
                System.out.println("Fizz");
            } else if (n%5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(n);
            }
        }
    }

    public static void replaceExample(String str) {
        System.out.println(str.replace("hi", ""));
    }

    public static void main(String[] args) {
        Main m = new Main();
        //System.out.println(m.generateCombinations(3));
        //m.plusMinus(List.of(1, 1, 0, -1, -1));
        //m.plusMinus(List.of(1, 2, 3, -1, -2, -3, 0, 0));
        //m.plusMinus(List.of(-4, 3, -9, 0, 4, 1));

        String[] titles = {"Shrek", "Avengers", "Rocky", "Titanic"};
        String[] votes = {"Shrek", "Avengers", "Avengers", "Avengers", "Shrek", "Rocky"};
        m.rank(titles, votes);
        List<Integer> list = new ArrayList<>();
        list.add(793810624);
        list.add(895642170);
        list.add(685903712);
        list.add(623789054);
        list.add(468592370);
        // 2572095760 2999145560
        //m.miniMaxSum(list);
        //m.fizzBuzz(15);
        //replaceExample("hihelloabchihiyahoo");
        String s = "asd";

    }

}
