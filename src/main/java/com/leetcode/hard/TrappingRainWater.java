package com.leetcode.hard;

public class TrappingRainWater {

    public int trap(int[] height) {
        //System.out.println("input: " + Arrays.toString(height));
        int fromIndex = getFromIndex(height);
        if (fromIndex == -1) {
            // all are 0
            return 0;
        }
        int toIndex = getToIndex(height, fromIndex);

        int count = 0;

        while (toIndex != -1) {
            count+=countWater(height, fromIndex, toIndex);
            fromIndex = toIndex;
            toIndex = getToIndex(height, fromIndex);
        }

        // count from right to left
        int[] subarray = reverseSubarray(height, fromIndex);
        fromIndex = getFromIndex(subarray);
        if (fromIndex == -1) {
            // no need to do anything else
        } else {
            toIndex = getToIndex(subarray, fromIndex);
            while (toIndex != -1) {
                count+=countWater(subarray, fromIndex, toIndex);
                fromIndex = toIndex;
                toIndex = getToIndex(subarray, fromIndex);
            }
        }

        return count;
    }

    public int countWater(int[] height, int fromIndex, int toIndex) {
        int min = Math.min(height[fromIndex], height[toIndex]);
        int count = 0;
        for (int i=fromIndex+1; i<toIndex; i++) {
            int item = height[i];
            count+=min-item;
        }
        return count;
    }

    public int[] reverseSubarray(int[] height, int fromIndex) {
        int len = height.length - fromIndex;
        int[] subarray = new int[len];
        int index = height.length-1;
        for (int i=0; i<len; i++) {
            subarray[i] = height[index];
            index--;
        }
        return subarray;
    }

    public int getFromIndex(int[] height) {
        for (int i=0; i<height.length; i++) {
            if (height[i] > 0)
                return i;
        }
        return -1;
    }

    public int getToIndex(int[] height, int fromIndex) {
        int item = height[fromIndex];
        for (int i=fromIndex+1; i<height.length; i++) {
            if (height[i] >= item)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        int[] trap = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(t.trap(trap));
    }

}
