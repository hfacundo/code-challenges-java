package com.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int index = 0;

        // validate row left vs right
        while (index < matrix.size()) {
            if (!isLeftMax(matrix.get(index))) {
                swapRightToLeft(matrix.get(index));
            }
            index++;
        }
        System.out.println();
        System.out.println("after swapping right to left");
        matrix.forEach(System.out::println);

        index = 0;
        // validate columns up vs bottom
        while (index < matrix.size()) {
            if (!isUpMax(matrix, index)) {
                swapBottomToUp(matrix, index);
            }
            index++;
        }

        System.out.println();
        System.out.println("After swapping bottom to up");
        matrix.forEach(System.out::println);
        return getSumOfLeftQuadrant(matrix);
    }

    // validate left elements vs right
    public static boolean isLeftMax(List<Integer> row) {
        int sumLeft = row.subList(0, row.size()/2).stream().collect(Collectors.summingInt(Integer::intValue));
        int sumRight = row.subList(row.size()/2, row.size()).stream().collect(Collectors.summingInt(Integer::intValue));
        return sumLeft > sumRight;
    }

    public static boolean isUpMax(List<List<Integer>> matrix, int columnIndex) {
        int sumUp = 0;
        int sumBottom = 0;

        for (int x=0; x<matrix.size(); x++) {
            if (x < matrix.size()/2) {
                sumUp+=matrix.get(x).get(columnIndex);
            } else {
                sumBottom+=matrix.get(x).get(columnIndex);
            }
        }

        return sumUp > sumBottom;
    }

    public static void swapRightToLeft(List<Integer> row) {
        List<Integer> list = new ArrayList<>();
        for (int x=row.size()-1; x >= 0; x--) {
            list.add(row.get(x));
        }
        for (int x=0; x<row.size(); x++) {
            row.set(x, list.get(x));
        }
    }

    public static void swapBottomToUp(List<List<Integer>> matrix, int columnIndex) {
        List<Integer> list = new ArrayList<>();
        for (int x=matrix.size()-1; x >= 0; x--) {
            list.add(matrix.get(x).get(columnIndex));
        }
        for (int x=0; x<matrix.size(); x++) {
            matrix.get(x).set(columnIndex, list.get(x));
        }
    }

    public static int getSumOfLeftQuadrant(List<List<Integer>> matrix) {
        int result = 0;
        for (int x=0; x<matrix.size()/2; x++) {
            for (int y=0; y<matrix.size()/2; y++) {
                result+=matrix.get(x).get(y);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        /*
        List<Integer> row1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> row2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> row3 = new ArrayList<>(Arrays.asList(4, 5, 6, 6));
        List<Integer> row4 = new ArrayList<>(Arrays.asList(0, 1, 4, 6));
         */
        List<Integer> row1 = new ArrayList<>(Arrays.asList(112, 42, 83, 119));
        List<Integer> row2 = new ArrayList<>(Arrays.asList(56, 125, 56, 49));
        List<Integer> row3 = new ArrayList<>(Arrays.asList(15, 78, 101, 43));
        List<Integer> row4 = new ArrayList<>(Arrays.asList(62, 98, 114, 108));
        List<List<Integer>> matrix = new ArrayList<>(Arrays.asList(row1, row2, row3, row4));
        matrix.forEach(System.out::println);
        int sumLeftQuadrant = flippingMatrix(matrix);
        System.out.println();
        System.out.println(sumLeftQuadrant);
    }
}
