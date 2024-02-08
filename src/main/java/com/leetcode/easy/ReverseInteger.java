package com.leetcode.easy;

import java.util.Map;
import java.util.TreeMap;

public class ReverseInteger {

    /**
     * Input: 123
     * Output: 321
     *
     * Input: -123
     * Output: -321
     *
     * Input: 120
     * Output: 21
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        if (x==0)
            return x;

        boolean isNegative = x < 0;

        int num = Math.abs(x);
        int reversed = 0;

        while (num > 0) {
            reversed*=10;
            reversed+=num%10;
            num/=10;
        }

        return isNegative ? reversed*-1 : reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        Map<Integer, Integer> map = new TreeMap<>();
        map.put(4, 3);
        map.put(5, 3);
        map.put(1, 2);
        System.out.println(map);

        System.out.println(map.keySet().stream().findFirst().get());
    }
}
