package com.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindSum {

    /*
    Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target
    [1, 2, 3, 4, 5], target sum = 7; result [2, 5]
     */
    public int[] findPair(int[] array, int target) {
        List<Integer> elements = Arrays.stream(array).boxed().collect(Collectors.toList());
        int[] result = new int[2];

        for (int x=0; x<elements.size(); x++) {
            int num = elements.get(x);
            if (num < target
                    && x+1 < elements.size()
                    && elements.subList(x+1, elements.size()).contains(target - num)) {
                result[0] = num;
                result[1] = target-num;
                return result;
            }
        }
        result[0] = -1;
        result[1] = -1;
        return result;
    }

    // [1, 2, 3, 4, 5, 9], target sum = 7; result [2, 5]
    // [1, 2, 3, 4, 5], target sum = 7; result [2, 5]
    public int[] findPairTwoPointersSolution(int[] array, int target) {
        int[] result = new int[2];
        int from = 0;
        int to = array.length-1;

        while (from < to) {
            if (array[from] + array[to] > target) {
                to--;
            } else if (array[from] + array[to] < target) {
                from++;
            } else if (array[from] + array[to] == target) {
                result[0] = array[from];
                result[1] = array[to];
                return array;
            }
        }

        result[0] = -1;
        result[1] = -1;
        return result;
    }

    public static void main(String[] args) {
        FindSum f = new FindSum();
        int[] array = {1, 2, 3, 4, 5};
        int[] result = f.findPair(array, 7);
        System.out.println(result[0]);
        System.out.println(result[1]);

        System.out.println("");
        System.out.println("two pointer solution");
        result = f.findPair(array, 7);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

}
