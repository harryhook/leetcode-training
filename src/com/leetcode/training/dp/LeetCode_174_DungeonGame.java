package com.leetcode.training.dp;

import java.util.Arrays;

/**
 * @author haowei.chen
 * @since 2022/12/21 21:33
 */
public class LeetCode_174_DungeonGame {

    public static void main(String[] args) {
        LeetCode_174_DungeonGame client = new LeetCode_174_DungeonGame();
        int res = client.calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}});
        System.out.println(res);
    }

    int[][] memo;

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dp(dungeon, 0, 0);
    }

    private int dp(int[][] dungeon, int i, int j) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // base case 走到最后一格，至少需要1格血条
        if (i == m - 1 && j == n - 1) {
            return dungeon[i][j] >= 0 ? 1 : 1 - dungeon[i][j];
        }
        // 过界
        if (i == m || j == n) {
            return Integer.MAX_VALUE;
        }
        // 计算过的位置不再参与计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int res = Math.min(dp(dungeon, i + 1, j), dp(dungeon, i, j + 1)) - dungeon[i][j];
        // 保证至少有1格血条
        memo[i][j] = res <= 0 ? 1 : res;

        return memo[i][j];


    }

}
