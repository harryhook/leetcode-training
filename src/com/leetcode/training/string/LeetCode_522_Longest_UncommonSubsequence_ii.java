package com.leetcode.training.string;

import java.util.Arrays;

/**
 * @author haowei.chen
 * @since 2024/6/17 21:11
 */
public class LeetCode_522_Longest_UncommonSubsequence_ii {

    public static void main(String[] args) {
        LeetCode_522_Longest_UncommonSubsequence_ii client = new LeetCode_522_Longest_UncommonSubsequence_ii();
        String[] strs = {"aebdc", "abdc", "ab"};
        System.out.println(client.findLUSlength(strs));
    }

    public int findLUSlength(String[] strs) {
        // 排序，由长到短排序
        Arrays.sort(strs, (a, b) -> b.length() - a.length());

        for (int i = 0; i < strs.length; i++) {
            boolean unCommonFlag = true;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    unCommonFlag = false;
                    break;
                }
            }
            if (unCommonFlag) {
                return strs[i].length();
            }
        }
        return -1;
    }

    private boolean isSubsequence(String str1, String str2) {

        // str1 是 str2 的子序列
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == str1.length();

    }
}