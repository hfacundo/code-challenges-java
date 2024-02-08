package com.challenge;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationExample {

    /*
    Given two integers n and k, return all possible combinations of k numbers our of 1...n
    You may return the answer in any order

    Example1:

    Input: n=4, k=2
    Output: [
        [2,4],
        [3,4],
        [2,3],
        [1,2],
        [1,3],
        [1,4]
    ]
     */
    public List<List<Integer>> getCombinations(int n, int k) {
        if (k > n) {
            return new ArrayList<>();
        }
        List<List<Integer>> combinations = new ArrayList<>();
        combine(1, n, k, new ArrayList<>(), combinations);
        return combinations;
    }

    public void combine(int i, int n, int k, List<Integer> comb, List<List<Integer>> combinations) {
        if (k == 0) {
            combinations.add(new ArrayList<>(comb));
            return;
        }

        for (int x=i; x<=n; x++) {
            comb.add(x);
            combine(x+1, n, k-1, comb, combinations);
            comb.remove(comb.size()-1);
        }
    }

    public static List<String> combinationExample(String word) {
        List<Character> chars = toChars(word);
        List<Integer> indexes = initializeIndexes(word);
        List<String> result = new ArrayList<>();

        boolean keepProcessing = true;
        StringBuilder builder = new StringBuilder();

        while (keepProcessing) {
            for (int x=0; x<indexes.size(); x++) {
                builder.append(chars.get(indexes.get(x)));
            }
            if (!updateIndexes(indexes, word.length())) {
                keepProcessing = false;
            }
            result.add(builder.toString());
            builder.setLength(0);
        }

        return result;
    }

    // abc -> abc, bac, bca, cab, cba
    public static List<String> combinationUnrepeatedExample(String word) {
        List<Character> chars = toChars(word);
        List<Integer> indexes = initializeIndexes(word);
        List<String> result = new ArrayList<>();

        boolean keepProcessing = true;
        StringBuilder builder = new StringBuilder();

        while (keepProcessing) {
            Set<Integer> set = new TreeSet<>();
            for (int x=0; x<indexes.size(); x++) {
                builder.append(chars.get(indexes.get(x)));
                set.add(indexes.get(x));
            }
            if (!updateIndexes(indexes, word.length())) {
                keepProcessing = false;
            }
            if (set.size() == 3) {
                result.add(builder.toString());
            }
            set.clear();
            builder.setLength(0);
        }

        return result;
    }

    // size 3
    // 1, 0, 0
    public static boolean updateIndexes(List<Integer> indexes, int size) {
        int i = indexes.size() - 1;
        int from = -1;

        while (i >= 0) {
            if (indexes.get(i) < size-1) {
                indexes.set(i, indexes.get(i) + 1);
                if (from != -1) {
                    // set to 0 from to end
                    for (int x=from; x<indexes.size(); x++) {
                        indexes.set(x, 0);
                    }
                }
                return true;
            } else {
                from = i;
                i--;
            }
        }

        return false;
    }

    public static List<Integer> initializeIndexes(String word) {
        List<Integer> indexes = new ArrayList<>();
        for (int x=0; x<word.length(); x++) {
            indexes.add(0);
        }
        return indexes;
    }
    public static List<Character> toChars(String word) {
        List<Character> chars = new ArrayList<>();
        for (Character c : word.toCharArray()) {
            chars.add(c);
        }
        return chars;
    }

    public static void main(String[] args) {
        CombinationExample c = new CombinationExample();
        //System.out.println(c.getCombinations(3, 3));
        System.out.println(combinationExample("abc"));
        System.out.println(combinationUnrepeatedExample("abc"));
    }
}
