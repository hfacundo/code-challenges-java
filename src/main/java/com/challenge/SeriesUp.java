package com.challenge;

public class SeriesUp {

    public int[] seriesUp(int n) {
        int size = n*(n+1)/2;
        int[] nums = new int[size];
        int max = 1;
        int x = 0;

        while (x < size) {
            for (int c=1; c<=max; c++) {
                nums[x] = c;
                x++;
            }
            max++;
        }

        return nums;
    }

    public static void main(String[] args) {
        SeriesUp s = new SeriesUp();
        System.out.println(s.seriesUp(3));
    }
}
