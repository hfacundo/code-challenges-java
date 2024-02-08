package com.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Array3 {

    /*
        canBalance([1, 1, 1, 2, 1]) → true
        canBalance([2, 1, 1, 2, 1]) → false
        canBalance([10, 10]) → true
    */
    public boolean canBalance(int[] nums) {
        if (nums.length <= 1)
            return false;
        List<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int x=1; x<numbers.size(); x++) {
            if (getCount(numbers, 0, x) == getCount(numbers, x, numbers.size()))
                return true;
        }
        return false;
    }

    private int getCount(List<Integer> numbers, int from, int to) {
        return numbers.subList(from, to).stream().collect(Collectors.summingInt(Integer::intValue));
    }

    public static void main(String[] args) {
        Array3 a = new Array3();
        int[] nums = {1, 1, 1, 2, 1};
        System.out.println(a.canBalance(nums));
    }
}
