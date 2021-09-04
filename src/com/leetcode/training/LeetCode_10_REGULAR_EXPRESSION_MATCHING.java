package com.leetcode.training;

public class LeetCode_10_REGULAR_EXPRESSION_MATCHING {

    public static void main(String[] args) {
        LeetCode_10_REGULAR_EXPRESSION_MATCHING client = new LeetCode_10_REGULAR_EXPRESSION_MATCHING();

        System.out.println(client.isMatch("aaa", "ab*a*c*a"));
    }


    public boolean isMatch(String s, String p) {


        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;
        // a*, a*b. a*b*c
        for (int i = 1; i < dp[0].length; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];

                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] | dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
