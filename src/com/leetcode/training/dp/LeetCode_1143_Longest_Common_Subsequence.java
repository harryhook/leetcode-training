package com.leetcode.training.dp;

import java.util.*;

public class LeetCode_1143_Longest_Common_Subsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length()+1][text2.length()+1];
        int res = 0;
        for(int i=0; i<text1.length(); i++) {
            for(int j=0; j<text2.length(); j++) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
                res = Math.max(res, dp[i+1][j+1]);
            }
        }

        return res;

    }

    public String longCommonSubSequence(String s1, String s2) {

        if (s1 == null || s2 == null) return null;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        int max = 0;
        int end = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > max) {
                    end = i;
                    max = dp[i][j];
                }
            }
        }

        return s1.substring(end - max, end);
    }

    public static void main(String[] args) {
        String s1 = "fbaroot";
        String s2 = "foobar";
        String s3 = "footbart";
        List<String> strs = new ArrayList<>();
        strs.add(s1);
        strs.add(s2);
        strs.add(s3);

        LeetCode_1143_Longest_Common_Subsequence client = new LeetCode_1143_Longest_Common_Subsequence();
        System.out.println(client.longestCommonSubsequence("fbaroot", "foobar"));
    }

    public String solution(List<String> strs) {

        if (strs.size() == 0) return "";

        String s1 = strs.get(0);
        List<List<String>> res = new ArrayList<>(strs.size());

        for (int i = 0; i < s1.length(); i++) {
            for (int j = i; j < s1.length(); j++) {

                String sub = s1.substring(i, j + 1);
                for (int k = 0; i < strs.size(); i++) {
                    if (strs.get(k).contains(sub)) {
                        res.get(k).add(sub);
                    }
                }

            }
        }

        for(int i =0; i<res.size() -1 ; i++) {
            res.get(i).retainAll(res.get(i+1));
        }



        return res.get(0).get(0);
    }
}
