package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleChallenge {

    /**
     * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
     * In Pascal's triangle, each number is the sum of the two numbers directly above it.
     *
     * Example:
     *
     * Input: 5
     * Output:
     *
     * [
     *        [1],
     *      [1, 1],
     *    [1, 2, 1],
     *   [1, 3, 3, 1],
     *  [1, 4, 6, 4, 1]
     * ]
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        /*
         * 1. First and last value are always one
         * 2. When index is after first element -> read last array and start from first position to position +1
         */
        for (int x=1; x<=numRows; x++) {
            List<Integer> row = new ArrayList<>();
            if (x > 2) {
                for (int y=0; y<x; y++) {
                    if (y == 0 || y == x-1) {
                        row.add(1);
                    } else {
                        int num = result.get(x-2).get(y-1) + result.get(x-2).get(y);
                        row.add(num);
                    }
                }
            } else {
                for (int y=0; y<x; y++) {
                    row.add(1);
                }
            }
            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> pascalNumbers = generatePascalTriangle(0);
        pascalNumbers.forEach(System.out::println);
    }

}
