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
 * 最终结果是 dp 数组中的最大值， 而不是包含最后一个元素时的最大值
 *   nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *   dp[0] = -2
 *
 *   到 1：
 *   dp[1] = max(dp[0] + 1, 1)
 *         = max(-1, 1)
 *         = 1
 *
 *   到 -3：
 *   dp[2] = max(1 + (-3), -3)
 *         = max(-2, -3)
 *         = -2
 *
 *   到 4：
 *   dp[3] = max(-2 + 4, 4)
 *         = max(2, 4)
 *         = 4
 *
 *   到 -1：
 *   dp[4] = max(4 + (-1), -1)
 *         = 3
 *
 *   到 2：
 *   dp[5] = max(3 + 2, 2)
 *         = 5
 *
 *   到 1：
 *   dp[6] = max(5 + 1, 1)
 *         = 6
 *   所以最大值是 6。
 */
public class LeetCode_53_MaximumSubarray {

    public static void main(String[] args) {
        LeetCode_53_MaximumSubarray client = new LeetCode_53_MaximumSubarray();

        int res = client.maximumSubbary(new int[]{-2,1,-3,4,-1,2,1,-5,4});

        System.out.println(res);
    }
    public int maximumSubbary(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = dp[0];
        for(int i=1; i<nums.length; i++) {
            if(dp[i-1] < 0) {
                dp[i] = nums[i];
            } else  {
                dp[i] = dp[i-1] + nums[i];
            }
            ans  = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
