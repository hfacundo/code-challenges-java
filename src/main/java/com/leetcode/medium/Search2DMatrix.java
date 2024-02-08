package com.leetcode.medium;

/**
 * Write an efficient algorithm that searches for a value in a m x n matrix. This matrix
 * has the following properties:
 *
 *  * Integers in each row are sorted from left to right
 *  * The first integer of each row is greater than the last integer of the previous row
 *
 * Example 1:
 *  Input:
 *  matrix = [
 *      [1, 3, 5, 7],
 *      [10, 11, 16, 20],
 *      [23, 30, 34, 50]
 *  ]
 *  target = 3
 *  Output: true
 */
public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix.length/2;
        int y = matrix[0].length/2;
        int exit = 0;

        while ( x >= 0 && x < matrix.length && exit < matrix.length * matrix[0].length) {
            int num = matrix[x][y];
            System.out.println("target: "+target+", num: " + num + ", x: " + x + ", y: " + y + " (exit: " + exit + ")");
            if (num == target)
                return true;

            if (num > target && y == 0) {
                x--;
                y = matrix[0].length/2;
            } else if (num < target && y == matrix[0].length-1) {
                x++;
                y = matrix[0].length/2;
            } else if (num > target) {
                y = y/2;
            } else if (num < target) {
                // fix here
                // y = y + (matrix[0].length - y) / 2;
                y++;
            }

            exit++;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 5, 7, 8},
                {10, 11, 12, 16, 18, 20},
                {21, 23, 30, 33, 34, 50},
                {61, 63, 70, 73, 84, 90}
        };
        System.out.println(searchMatrix(matrix, 3)); // true
    }
}
