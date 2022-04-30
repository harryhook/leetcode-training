package com.leetcode.training;

/**
 * 最大连续子数组和
 * 动态方程
 *             if(dp[i-1] < 0) {
 *                 dp[i] = nums[i];
 *             } else  {
 *                 dp[i] = dp[i-1] + nums[i];
 *             }
 *
 */
public class LeetCode_53_MaximumSubarray {

    public static void main(String[] args) {
        LeetCode_53_MaximumSubarray client = new LeetCode_53_MaximumSubarray();

        int res = client.maximumSubbary(new int[]{-5,5,-3,3,4,5});

        System.out.println(res);
    }
    public int maximumSubbary(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for(int i=1; i<nums.length; i++) {
            if(dp[i-1] < 0) {
                dp[i] = nums[i];
            } else  {
                dp[i] = dp[i-1] + nums[i];
            }
        }
        return dp[nums.length-1];
    }
}
//update!
