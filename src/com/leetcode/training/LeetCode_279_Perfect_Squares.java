package com.leetcode.training;

public class LeetCode_279_Perfect_Squares {


    public static void main(String[] args) {
        LeetCode_279_Perfect_Squares client = new LeetCode_279_Perfect_Squares();

        System.out.println(client.numSquares2(12));
    }

    public int numSquares(int n) {

        int sqrt = (int) Math.sqrt(n);

        if (sqrt * sqrt == n) {
            return 1;
        }
        int[][] dp = new int[sqrt + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[1][i] = i;
        }


        for (int i = 2; i <= sqrt; i++) {

            for (int j = 1; j <= n; j++) {

                if (j < i * i) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j == i * i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(dp[i][j - i * i] + 1, dp[i - 1][j]);
                }

            }
        }
        return dp[sqrt][n];
    }

    public int numSquares2(int n) {


        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}
