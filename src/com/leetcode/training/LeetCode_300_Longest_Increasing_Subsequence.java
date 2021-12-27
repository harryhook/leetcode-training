package com.leetcode.training;

import java.util.Arrays;

public class LeetCode_300_Longest_Increasing_Subsequence {


    public static void main(String[] args) {
        LeetCode_300_Longest_Increasing_Subsequence client = new LeetCode_300_Longest_Increasing_Subsequence();

        int cnt = client.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});

        System.out.println(cnt);
    }

    public int lengthOfLIS(int[] nums) {

        int[] length = new int[nums.length];
        Arrays.fill(length, 1);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {
                    length[i] = Math.max(length[j] + 1, length[i]);
                }
            }
            res = Math.max(res, length[i]);

        }
        return res;
    }
}
