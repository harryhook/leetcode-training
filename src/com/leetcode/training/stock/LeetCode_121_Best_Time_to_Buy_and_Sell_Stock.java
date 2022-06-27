package com.leetcode.training.stock;

public class LeetCode_121_Best_Time_to_Buy_and_Sell_Stock {

    public static void main(String[] args) {
        LeetCode_121_Best_Time_to_Buy_and_Sell_Stock client = new LeetCode_121_Best_Time_to_Buy_and_Sell_Stock();
        System.out.println(client.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        // 找到一个最小值，然后从后面找到一个最大值，然后计算出最大值减去最小值
        int res = 0, currMin = prices[0];

        for (int sell = 1; sell < prices.length; sell++) {
            currMin = Math.min(currMin, prices[sell]);
            res = Math.max(res, prices[sell] - currMin);
        }

        return res;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length < 2) return 0;
        // 找到一个最小值，然后从后面找到一个最大值，然后计算出最大值减去最小值
        int res = 0, currMin = prices[0];
        // 此时k = 1,
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            // 对 i=0 进行处理
            if (i == 0) {
                /**
                 * dp[i][0] =
                 * max(dp[-1][0],dp[-1][1]prices[i])
                 * max(0,-infinity prices[i])=0
                 */
                dp[i][0] = 0;
                /**
                 * dp[i][1] =
                 * max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
                 * max(-inf,  0 - prices[i]);
                 */
                dp[i][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],  - prices[i]);
        }
        return dp[prices.length - 1][0];

    }

    public int maxProfit3(int[] prices) {
        if (prices.length < 2) return 0;
        // 找到一个最小值，然后从后面找到一个最大值，然后计算出最大值减去最小值
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1,  - prices[i]);
        }
        return dp_i_0;

    }

}
