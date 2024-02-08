package com.leetcode.medium;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *  Input: 3
 *  Output: [
 *      [1, 2, 3],
 *      [8, 9, 4],
 *      [7, 6, 5]
 *  ]
 */
public class SpiralMatrixII {

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int x=0;
        int y=0;
        int i=0;
        int limitX=n;
        int limitY=n;
        // right, down, left, up
        String direction = "right";

        for (int num=1; num<=n*n; num++) {

            if (direction.equals("right")) {
                if (i < limitY) {
                    matrix[x][y] = num;
                    i++;
                    y++; // we need to extract 1 when "right" is done
                } else {
                    i = 0;
                    y--; // extracting 1
                    x++;
                    limitX--;
                    direction = "down";
                }
            }

            if (direction.equals("down")) {
                if (i < limitX) {
                    matrix[x][y] = num;
                    x++;
                    i++;
                } else {
                    i=0;
                    x--; // we need to extract 1 when "down" is done
                    limitY--;
                    y--;
                    direction = "left";
                }
            }

            if (direction.equals("left")) {
                if (i < limitY) {
                    matrix[x][y] = num;
                    y--;
                    i++;
                } else {
                    i=0;
                    y++; // we need to add 1 when "left" is done
                    limitX--;
                    x--;
                    direction = "up";
                }
            }

            if (direction.equals("up")) {
                if (i < limitX) {
                    matrix[x][y] = num;
                    x--;
                    i++;
                } else {
                    i=0;
                    x++;
                    y++;
                    limitY--;
                    direction = "right";
                    num--;
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        for (int x = 0; x< matrix.length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                if (y+1 == matrix.length) {
                    System.out.println(matrix[x][y]);
                } else {
                    System.out.print(matrix[x][y] + ", ");
                }
            }
        }
    }

}
