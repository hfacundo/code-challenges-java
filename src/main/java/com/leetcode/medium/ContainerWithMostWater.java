package com.leetcode.medium;

public class ContainerWithMostWater {

    /**
     * Get the max area of next representation
     *
     * 8 |_
     * 7 |_    |              |
     * 6 |_    |¨¨¨¨¨¨¨¨¨¨¨¨¨¨|¨¨¨¨¨|
     * 5 |_    |  |           |     |
     * 4 |_    |  |     |     |     |
     * 3 |_    |  |     |  |  |     |
     * 2 |_    |  |     |  |  |  |  |
     * 1 |_    |  |  |  |  |  |  |  |
     * 0 |__|__|__|__|__|__|__|__|__|
     *
     * The above vertical lines are represented by array
     *     [1, 8, 6, 2, 5, 4, 8, 3, 7]
     *
     * In this case, the max area of water is 49
     *         8                    7
     * There are 7 elements between 8 and 7 in the array
     * and the number 7 is the smallest of the 2 elements that can hold more water
     * so 7*7=49
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int from = 0;
        int to = height.length-1;
        int max = 0;
        int sum;

        while (from < to) {
            int min = Math.min(height[from], height[to]);
            sum = min * (to-from);
            max = Math.max(max, sum);
            if (height[from] < height[to]) {
                from++;
            } else {
                to--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(array));
    }
}
