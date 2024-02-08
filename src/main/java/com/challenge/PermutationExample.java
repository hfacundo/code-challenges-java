package com.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationExample {

    private final char DELIMITER = ',';
    public void getAllPermutations(int[] elements, int n) {
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = 0;
        }

        printArray(elements, ',');
        int i = 0;
        while (i < n) {
            if (indexes[i] < i) {
                swap(elements, i % 2 == 0 ?  0: indexes[i], i);
                printArray(elements, DELIMITER);
                indexes[i]++;
                i = 0;
            }
            else {
                indexes[i] = 0;
                i++;
            }
        }

    }

    private static void swap(int[] elements, int a, int b) {
        int tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }

    private static void printArray(int[] elements, char delimiter) {
        String delimiterSpace = delimiter + " ";
        for(int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + delimiterSpace);
        }
        System.out.print('\n');
    }

    // 1, 2, 3
    public void printPermutations(int[] array) {
        List<Integer> numbers = Arrays.stream(array).boxed().collect(Collectors.toList());

    }

    public static void main(String[] args) {
        PermutationExample p = new PermutationExample();
        int[] array = {1, 2, 3};
        p.getAllPermutations(array, 3);
    }
}
