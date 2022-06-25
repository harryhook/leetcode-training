package com.leetcode.training.stock;

public class LeetCode_122_Best_Time_2_Buy_and_Sell_Stock_II {

    public static void main(String[] args) {
        LeetCode_122_Best_Time_2_Buy_and_Sell_Stock_II client = new LeetCode_122_Best_Time_2_Buy_and_Sell_Stock_II();
        int profit = client.maxProfit(new int[] {7, 1, 5, 3, 6, 4});
        System.out.println(profit);
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
