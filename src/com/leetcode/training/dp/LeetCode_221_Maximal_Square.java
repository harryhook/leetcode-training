package com.leetcode.training.dp;

public class LeetCode_221_Maximal_Square {

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        LeetCode_221_Maximal_Square client = new LeetCode_221_Maximal_Square();
        System.out.println(client.maximalSquare(matrix));
    }
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m + 1][n + 1];
        int result = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result*result;
    }
}
