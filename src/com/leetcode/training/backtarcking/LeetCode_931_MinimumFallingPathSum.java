package com.leetcode.training.backtarcking;

import java.util.Arrays;

/**
 * @author haowei.chen
 * @since 2022/12/20 19:57
 */
public class LeetCode_931_MinimumFallingPathSum {

    public static void main(String[] args) {
        LeetCode_931_MinimumFallingPathSum client = new LeetCode_931_MinimumFallingPathSum();
        int res = client.minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}});
        System.out.println(res);
    }

    int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;

        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 66666);
        }
        for (int j = 0; j < n; j++) {
            // 结果是最后一列元素中的最小值
            res = Math.min(res, dfs(matrix, n - 1, j));
        }

        return res;
    }

    // matrix[i][j] 表示从第i行第j列出发的最小路径和, 可以分别从matrix[i-1][j-1], matrix[i-1][j], matrix[i-1][j+1]出发
    private int dfs(int[][] matrix, int i, int j) {
        int n = matrix.length;
        // 过界
        if (i < 0 || j < 0 || i >= n || j >= n) {
            return Integer.MAX_VALUE;
        }
        // 倒推的终点元素
        if (i == 0) {
            return matrix[i][j];
        }
        // 计算过的位置不再参与计算
        if (memo[i][j] != 66666) {
            return memo[i][j];
        }
        // 递归
        memo[i][j] = matrix[i][j] + Math.min(dfs(matrix, i - 1, j - 1), Math.min(dfs(matrix, i - 1, j), dfs(matrix, i - 1, j + 1)));

        return memo[i][j];
    }

}
