package com.leetcode.training;

public class LeetCode_152_MaxProduct {

    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] f = new int[nums.length];
        int[] g = new int[nums.length];

        f[0] = nums[0];
        g[0] = nums[0];

        int res = nums[0];
        for(int i=1; i<nums.length; i++) {
            f[i] = Math.max(Math.max(f[i-1] * nums[i], g[i-1] * nums[i]), nums[i]);
            g[i] = Math.min(Math.min(f[i-1] * nums[i], g[i-1] * nums[i]), nums[i]);

            res = Math.max(res, f[i]);
        }

        return res;

    }
}
