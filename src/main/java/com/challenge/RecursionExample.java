package com.challenge;

import java.util.ArrayList;
import java.util.List;

public class RecursionExample {

    public int sumN(int n) {
        if (n == 1)
            return 1;
        return sumN(n-1)+n;
    }

    public int calculatorMultiply(int number, int secondNumber) {
        if (secondNumber <= 1)
            return number;
        return number + calculatorMultiply(number, secondNumber-1);
    }

    /*
    Write a function "sum" that takes an array of numbers as an input. The function should return the total sum of all elements
    The function must be recursive

    sum([1, 5, 7, -2]) // 11
    sum([6, 3, 1, -2]) // 10
     */
    public int sum(int[] nums, int index) {
        if (index == 0)
            return nums[index];
        return nums[index] + sum(nums, index-1);
    }

    // fibonacci series sum 2 last elements given as result
    // 1 1 2 3 5 8 13
    public int fibonacci(int limit) {
        if (limit == 1 || limit == 2)
            return 1;
        return fibonacci(limit - 1) + fibonacci(limit -2);
    }

    public List<List<String>> getCombinations(List<String> elements) {
        if (elements.size() == 0) {
            return new ArrayList<>();
        }

        String first = elements.get(0);
        List<String> rest = elements.subList(1, elements.size());

        List<List<String>> combsWithoutFirst = getCombinations(rest);
        List<List<String>> combsWithFirst = new ArrayList<>();

        combsWithoutFirst.forEach(comb -> {
            List<String> combWithFirst = new ArrayList<>();
            combWithFirst.addAll(comb);
            combWithFirst.add(first);
            combsWithFirst.add(combWithFirst);
        });

        List<List<String>> combsWithoutFirstResult = new ArrayList<>();
        List<List<String>> combsWithFirstResult = new ArrayList<>();
        combsWithoutFirstResult.addAll(combsWithFirst);
        combsWithoutFirstResult.addAll(combsWithoutFirst);
        combsWithoutFirstResult.addAll(combsWithFirstResult);
        return combsWithoutFirstResult;
    }

    public static void main(String[] args) {
        RecursionExample r = new RecursionExample();
        List<String> elements = List.of("a", "b", "c");
        System.out.println(r.getCombinations(elements));
    }
}
