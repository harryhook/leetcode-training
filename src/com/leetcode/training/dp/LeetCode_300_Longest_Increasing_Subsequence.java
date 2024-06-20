package com.leetcode.training.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最长递增子序列长度
 * Example 1:
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Example 2:
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 *
 * 思路：dp[i] = max(dp[j]+1, dp[i]), 0<j<i, 计算当前元素的最大递增子序列个数
 */
public class LeetCode_300_Longest_Increasing_Subsequence {


    public static void main(String[] args) {
        LeetCode_300_Longest_Increasing_Subsequence client = new LeetCode_300_Longest_Increasing_Subsequence();

        int cnt = client.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});

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

    public int lengthOfLIS2(int[] nums) {

        if (nums.length == 1) return 1;

        List<Integer> res = new ArrayList<>();

        res.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {

            if (res.get(res.size() - 1) < nums[i]) {
                res.add(nums[i]);
            } else {

                int low = 0, high = res.size()-1;

                while(low <= high) {
                    int mid = low + (high-low)/2;
                    if(res.get(mid) < nums[i]) {
                        low = mid +1;
                    } else {
                        high = mid -1;
                    }
                }
                res.set(low, nums[i]);
            }
        }
        return res.size();
    }
}
