package com.challenge;

/**
 * Given an array of numbers where positive integers represent land and 0 represent water, count blocks of water
 * in the array
 *
 * Example 1:
 *  array = [2, 1, 0, 3]
 *  output: 5
 *
 *  |
 *  |                 |
 *  |    |¨¨¨¨¨¨¨¨¨¨¨¨|
 *  |____|____|_______|____
 *
 *  Note: It is not 6 because 1 is land and it took 1 from 6 water
 */
public class ContainerMostWaterII {

    // [0,1,0,2,1,0,1,3,2,1,2,1] output = 6
    public static int trap(int[] height) {
        if (height.length <= 1)
            return 0;
        int left = 0;
        int right = 1;
        int land = 0;
        int max = 0;

        int water = 0;
        while (right < height.length) {
            int colLeft = height[left];
            if (colLeft == 0) {
                // check in the next column
                left++;
                right++;
                continue;
            }
            int colRight = height[right];
            if (colRight >= colLeft) {
                water+=countWater(height, left, right, land);
                land = 0;
                left = right;
                max = 0;
            } else if (colRight > 0) {
                int count = countWater(height, left, right, land);
                if (count > max) {
                    max = count;
                }
                land+=colRight;
            } else {
                // colRight is 0
            }
            right++;
        }
        return water+max;
    }

    public static int countWater(int[] height, int left, int right, int land) {
        int min = Math.min(height[left], height[right]);
        int water = (right-left-1) * min - land;
        return water;
    }

    public static void main(String[] args) {
        //int[] array = {0,1,0,2,1,0,1,3,2,1,2,1};
        //System.out.println(trap(array));

        int[] array2 = {5,4,1,2};
        System.out.println(trap(array2));
    }

}
