package com.leetcode.training.stock;

public class LeetCode_121_Best_Time_to_Buy_and_Sell_Stock {

    public static void main(String[] args) {
        LeetCode_121_Best_Time_to_Buy_and_Sell_Stock client = new LeetCode_121_Best_Time_to_Buy_and_Sell_Stock();
        System.out.println(client.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    }
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        // 找到一个最小值，然后从后面找到一个最大值，然后计算出最大值减去最小值
        int res = 0, currMin = prices[0];

        for(int sell=1; sell<prices.length; sell++) {
            currMin = Math.min(currMin, prices[sell]);
            res = Math.max(res, prices[sell] - currMin);
        }

        return res;
    }
}
