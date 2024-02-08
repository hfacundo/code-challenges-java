package com.leetcode.medium;

public class FindValidWordInGrid {

    public static boolean existInGrid(String word, char[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (word.charAt(0) == grid[i][j] && explore(grid, i, j, 0, word, visited)) { // first character found
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean explore(char[][] grid, int i, int j, int charIndex, String word, boolean[][] visited) {
        if (charIndex == word.length()) {
            return true;
        }
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != word.charAt(charIndex) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (
                explore(grid, i, j+1, charIndex+1, word, visited) || // right
                explore(grid, i, j-1, charIndex+1, word, visited) || // left
                explore(grid, i-1, j, charIndex+1, word, visited) || // up
                explore(grid, i+1, j, charIndex+1, word, visited) // down
        )
            return true;

        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'A', 'B', 'C', 'D'},
                {'E', 'R', 'A', 'F'},
                {'J', 'F', 'E', 'F'}
        };
        String[] words = {"ERAF", "ABRF", "CARF", "ERAD"};

        for (String word: words) {
            boolean exist = existInGrid(word, grid);
            System.out.println(word + " exist in grid? -> " + exist);
        }
    }

}
