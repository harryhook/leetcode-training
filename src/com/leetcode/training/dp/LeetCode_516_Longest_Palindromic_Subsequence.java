package com.leetcode.training.dp;

/**
 * Example 1:
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 * <p>
 * Example 2:
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 *
 * 1.动态规划
 * 2.字符串翻转后求最大公共子串长度
 */
public class LeetCode_516_Longest_Palindromic_Subsequence {
    public int longestPalindromeSubseq(String s) {

        int[][] T = new int[s.length()][s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            T[i][i] = 1;
        }
        for (int l = 2; l <= s.length(); l++) {
            for (int i = 0; i < s.length() - l + 1; i++) {
                int j = i + l - 1;
                //首先得到 s 的下标范围 [i+1, j-1] 内的最长回文子序列,然后在该子序列的首尾分别添加 s[i] 和 s[j]
                if (chars[i] == chars[j]) {
                    T[i][j] = T[i + 1][j - 1] + 2;
                } else {
                    //如果 s[i] !=s[j],则 s[i]和 s[j] 不可能同时作为同一个回文子序列的首尾，
                    // 因此 dp[i][j]=max(dp[i+1][j],dp[i][j−1])
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                }
            }
        }

        return T[0][s.length() - 1];
    }
}
