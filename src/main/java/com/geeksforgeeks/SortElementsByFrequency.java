package com.geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Print the elements of an array in the decreasing frequency if 2 numbers have the same frequency then print the one which came first.

    Examples:

    Input : arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
    Output : arr[] = {8, 8, 8, 2, 2, 5, 5, 6}

    Input : arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8}
    Output : arr[] = {8, 8, 8, 2, 2, 5, 5, 6, -1, 9999999}
 */
public class SortElementsByFrequency {

    public static int[] sortElements(int[] array) {
        int[] result = new int[array.length];

        Map<Integer, Integer> mapOccurrences = new HashMap<>();
        Map<Integer, Integer> mapIndexes = new HashMap<>();
        for (int i=0; i< array.length; i++) {
            mapOccurrences.put(array[i], mapOccurrences.getOrDefault(array[i], 0) + 1);
            mapIndexes.putIfAbsent(array[i], i);
        }

        Comparator<Map.Entry<Integer, Integer>> comparatorByValue = (e1, e2) -> e2.getValue().compareTo(e1.getValue());
        // Comparator<Map.Entry<Integer, Integer>> comparatorByIndex = (e1, e2) -> mapIndexes.get(e1.getKey()).compareTo(mapIndexes.get(e2.getKey()));
        // Using method reference
        Comparator<Map.Entry<Integer, Integer>> comparatorByIndex = Comparator.comparing(e -> mapIndexes.get(e.getKey()));
        List<Integer> list = mapOccurrences.entrySet().stream()
                .sorted(comparatorByValue.thenComparing(comparatorByIndex))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        int i = 0;
        for (int num : list) {
            for (int j=0; j<mapOccurrences.get(num); j++) {
                result[i] = num;
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 2, 8, 5, 6, 8, 8};
        int[] result = sortElements(arr);
        System.out.println(Arrays.toString(result)); // {8, 8, 8, 2, 2, 5, 5, 6}

        arr = new int[]{2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
        result = sortElements(arr);
        System.out.println(Arrays.toString(result)); // {8, 8, 8, 2, 2, 5, 5, 6, -1, 9999999}
    }

}
