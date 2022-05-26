package com.leetcode.training.dp;

public class LongCommonSubSequence {

    public String longCommonSubSequence(String s1, String s2) {

        if (s1 == null || s2 == null) return null;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        int max = 0;
        int end = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > max) {
                    end  = i;
                    max = dp[i][j];
                }
            }
        }

        return s1.substring(end-max,  end);
    }

    public static void main(String[] args) {
        LongCommonSubSequence client = new LongCommonSubSequence();
        System.out.println(client.longCommonSubSequence("fbaroot", "foobar"));
    }
}
