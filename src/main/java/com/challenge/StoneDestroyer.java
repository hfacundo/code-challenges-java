package com.challenge;

import java.util.*;

public class StoneDestroyer {

    /*
        A Worker has to destroy rocks in pairs, always taking 2 biggest rocks
        if 2 rocks are same weight they both destroy completely
        if 1 rock is bigger than the other, smaller will be destroyed and bigger will break into a smaller rock with weight bigger - smaller

        return weight of remaining stone
        return 0 if all stones were destroyed
     */
    public static int stoneDestroy(List<Integer> numbers) {

        if (numbers.size() == 0)
            return 0;

        while (numbers.size() > 0) {
            if (numbers.size() > 1) {
                int max = numbers.get(numbers.size() -1);
                int min = numbers.get(numbers.size() -2);
                int result = max - min;
                numbers.remove(numbers.size() -1);
                numbers.remove(numbers.size() -1);
                if (result > 0)
                    addElementToList(numbers, result);
            } else {
                return numbers.get(0);
            }
        }

        return 0;
    }

    // 9
    // 1, 2, 3, 7, 9, 15
    public static void addElementToList(List<Integer> results, Integer number) {
        int index = 0;
        for (int x = results.size() -1; x>=0; x--) {
            if (number >= results.get(x)) {
                // we found the index
                index = x;
                break;
            }
        }

        if (index+1 == results.size()) {
            results.add(number);
        } else {
            int temp = results.get(index);
            results.set(index, number);
            for (int x=index+1; x< results.size(); x++) {
                int current = results.get(x);
                results.set(x, temp);
                temp = current;
            }
            results.add(temp);
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(3);
        numbers.add(7);
        numbers.add(9);
        System.out.println(stoneDestroy(numbers));

        Stack<String> stack = new Stack<>();

    }

}
