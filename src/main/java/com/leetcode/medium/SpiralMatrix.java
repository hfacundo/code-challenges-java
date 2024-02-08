package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /**
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order
     *
     * Example 1:
     *  Input:
     *  [
     *      [1, 2, 3],
     *      [4, 5, 6],
     *      [7, 8, 9]
     *  ]
     *  Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
     *
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        int max = matrix[0].length * matrix.length;
        int count = 0;

        int x=0;
        int y=0;
        int limitX = matrix.length;
        int limitY = matrix[0].length;
        int i = 0;
        String direction = "right";

        while (count < max) {
            if (direction.equals("right")) {
                while (i < limitY) {
                    results.add(matrix[x][y]);
                    y++;
                    i++;
                    count++;
                }
                if (i == limitY) {
                    y--; // to avoid out of bounds
                    limitX--;
                    x++;
                    i = 0;
                    direction = "down";
                    continue;
                }
            }
            if (direction.equals("down")) {
                while (i < limitX) {
                    results.add(matrix[x][y]);
                    x++;
                    i++;
                    count++;
                }
                if (i == limitX) {
                    x--; // to avoid out of bounds
                    limitY--;
                    y--;
                    i=0;
                    direction = "left";
                    continue;
                }
            }
            if (direction.equals("left")) {
                while (i < limitY) {
                    results.add(matrix[x][y]);
                    y--;
                    i++;
                    count++;
                }
                if (i == limitY) {
                    y++; // to avoid out of bounds
                    limitX--;
                    x--;
                    i=0;
                    direction = "up";
                    continue;
                }
            }
            if (direction.equals("up")) {
                while (i < limitX) {
                    results.add(matrix[x][y]);
                    x--;
                    i++;
                    count++;
                }
                if (i == limitX) {
                    x++; // to avoid out of bounds
                    limitY--;
                    y++;
                    i=0;
                    direction = "right";
                    continue;
                }

            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        //System.out.println(spiralOrder(matrix));

        matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(spiralOrder(matrix));
    }

}
