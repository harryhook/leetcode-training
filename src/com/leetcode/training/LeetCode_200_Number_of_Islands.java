package com.leetcode.training;

public class LeetCode_200_Number_of_Islands {


    public static void main(String[] args) {
        LeetCode_200_Number_of_Islands leetCode_200_number_of_islands = new LeetCode_200_Number_of_Islands();
        char[][] grid = {{'0', '0', '0'}, {'1', '1', '0'}, {'0', '0', '1'}};
        System.out.println(leetCode_200_number_of_islands.numIslands(grid));

    }

    public int numIslands(char[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '0' || visited[i][j]) continue;
                helper(grid, visited, i, j);
                res++;
            }
        }
        return res;
    }

    private void helper(char[][] grid, boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y] || grid[x][y] == '0') return;
        visited[x][y] = true;
        helper(grid, visited, x - 1, y);
        helper(grid, visited, x + 1, y);
        helper(grid, visited, x, y - 1);
        helper(grid, visited, x, y + 1);
    }
}
