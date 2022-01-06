package com.leetcode.training;

public class LeetCode_198_House_Robber {

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int []dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }


    public int rob2(int[] nums) {
        return Math.max(rob1(nums, 0, nums.length-1), rob1(nums, 1, nums.length));
    }

    public int rob1(int[] nums, int start, int end ) {

        if(nums.length == 1) return nums[0];
        int []dp = new int[nums.length-1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start+1]);

        for(int i=2; i<end-start; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length-2];
    }

    public static void main(String[] args) {
        LeetCode_198_House_Robber client = new LeetCode_198_House_Robber();

        System.out.println(client.rob2(new int[]{1,2,3,1}));
    }
}
