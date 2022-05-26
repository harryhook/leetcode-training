package com.leetcode.training;

/**
 * @author chenhaowei
 * @date 2020.11.13
 */
public class LeetCode_64_Minimum_Path_Sum {

    public static void main(String[] args) {
        LeetCode_64_Minimum_Path_Sum client = new LeetCode_64_Minimum_Path_Sum();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println( client.minPathSum(grid));;

    }

    public int minPathSum(int[][] grid) {
        int high = grid.length;
        int width = grid[0].length;
        for (int i = 1; i < high; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < width; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        for (int i = 1; i < high; i++) {
            for (int j = 1; j < width; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }

        return grid[high - 1][width - 1];
    }
}
