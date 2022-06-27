package com.leetcode.training.stock;

public class LeetCode_123_Best_Time_2_Buy_and_Sell_Stock_III {

    public static void main(String[] args) {
        LeetCode_123_Best_Time_2_Buy_and_Sell_Stock_III client = new LeetCode_123_Best_Time_2_Buy_and_Sell_Stock_III();

        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(client.maxProfit(prices));
    }
    /**
     * 一共有五个操作， 0-4， 0-无操作， 1-第一次买入， 2-第一次卖出 3-第二次买入， 4-第二次卖出
     * dp[i][0]
     * dp[i][1] = dp[i-1][0] - prices[i]  dp[i-1][1]
     * dp[i][2] = dp[i-1][1] + prices[i]  dp[i-1][2]
     * dp[i][3] = dp[i-1][2] - prices[i]  dp[i-1][3]
     * dp[i][4] = dp[i-1][3] + prices[i]  dp[i-1][4]
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int [][]dp = new int[prices.length][5];
        // basecase
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;

        for(int i=1; i<prices.length; i++) {
            dp[i][0] = dp[i-1][0];
            dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
            dp[i][2] = Math.max(dp[i-1][1] + prices[i], dp[i-1][2]);
            dp[i][3] = Math.max(dp[i-1][2] - prices[i], dp[i-1][3]);
            dp[i][4] = Math.max(dp[i-1][3] + prices[i], dp[i-1][4]);
        }

        return dp[prices.length-1][4];
    }
}
