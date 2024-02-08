package com.leetcode.easy;

public class FindIslandsChallenge {

    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
     * and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water
     *
     * Example 1:    Example 2:
     * 11110         11000
     * 11010         11000
     * 11000         00100
     * 00000         00011
     *
     * Output: 1     Output: 3
     */
    public static int findNumberOfIslands(int[][] grid) {
        int islands = 0;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    islands++;
                    updateGrid(grid, i, j);
                }
            }
        }

        return islands;
    }

    private static void updateGrid(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 ) {
            return;
        }
        grid[i][j] = 0;
        updateGrid(grid, i-1, j); // up
        updateGrid(grid, i+1, j); // down
        updateGrid(grid, i, j-1); // left
        updateGrid(grid, i, j+1); // right
    }

    public static void main(String[] args) {
        int[] r1 = {1, 1, 1, 1, 0};
        int[] r2 = {1, 1, 0, 1, 0};
        int[] r3 = {1, 1, 0, 0, 0};
        int[] r4 = {0, 0, 0, 0, 0};
        int[][] grid = {r1, r2, r3, r4};
        System.out.println(findNumberOfIslands(grid));

        r1 = new int[]{1, 1, 0, 0, 0};
        r2 = new int[]{1, 1, 0, 0, 0};
        r3 = new int[]{0, 0, 1, 0, 0};
        r4 = new int[]{0, 0, 0, 1, 1};
        grid = new int[][]{r1, r2, r3, r4};
        System.out.println(findNumberOfIslands(grid));

        r1 = new int[]{1, 1, 0, 0, 1};
        r2 = new int[]{1, 0, 1, 1, 0};
        r3 = new int[]{0, 0, 1, 0, 0};
        r4 = new int[]{0, 0, 0, 1, 1};
        grid = new int[][]{r1, r2, r3, r4};
        System.out.println(findNumberOfIslands(grid));

    }

}
