package com.challenge;

public class MathExamples {

    public static int pageCount(int n, int p) {
        int start = 0;
        int end = 0;

        if (p > 1) {
            start = p/2;
        }

        if (p < n-1) {
            end = (n - p)/2;
        }

        return Math.min(start, end);
    }

    public static void main(String[] args) {
        System.out.println(pageCount(6, 5));
        System.out.println(pageCount(5, 6));
    }
}
