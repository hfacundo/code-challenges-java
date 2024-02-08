package com.leetcode.easy;

/**
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i=0; i<flowerbed.length-1; i++) {
            if (i==0) {
                if (flowerbed[i] == 0 && isRight0(flowerbed, i)) {
                    count++;
                    //i++;
                }
            }  else if (i+2 >= flowerbed.length) { // we are at the end
                if (isLastValid(flowerbed, i)) {
                    count++;
                    i++;
                } else {
                    break;
                }
            } else {
                if (flowerbed[i] == 0 && isLeftAndRight0(flowerbed, i)) {
                    count++;
                    i++;
                }
            }

            if (count == n) {
                return true;
            }
        }

        return count == n;
    }

    public boolean isLastValid(int[] flowerbed, int i) {
        return flowerbed[i] == 0 && flowerbed[i+1] == 0;
    }

    public boolean isRight0(int[] flowerbed, int i) {
        return flowerbed[i+1] == 0;
    }

    public boolean isLeftAndRight0(int[] flowerbed, int i) {
        return flowerbed[i-1] == 0 && flowerbed[i+1] == 0;
    }

    public static void main(String[] args) {
        CanPlaceFlowers c = new CanPlaceFlowers();
        int[] array = {1,0,0,0,0};
        System.out.println(c.canPlaceFlowers(array, 2));
    }

}
