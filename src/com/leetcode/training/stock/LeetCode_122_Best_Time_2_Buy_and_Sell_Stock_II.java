package com.leetcode.training.stock;

import java.util.Arrays;

public class LeetCode_122_Best_Time_2_Buy_and_Sell_Stock_II {

    public static void main(String[] args) {
        LeetCode_122_Best_Time_2_Buy_and_Sell_Stock_II client = new LeetCode_122_Best_Time_2_Buy_and_Sell_Stock_II();
        int profit = client.maxProfit2(new int[] {7, 1, 5, 3, 6, 4});
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

    public int maxProfit2(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int res = 0;
        int currMin = prices[0];
        for(int sell=1; sell<prices.length; sell++) {
            currMin = Math.min(currMin, prices[sell]);
            // 当天交易 + 后续交易
            res = Math.max(res, helper(prices, sell+1) +  prices[sell] - currMin);
        }

        return res;
    }

    private int helper(int[] prices,  int start) {
        if(start >= prices.length) return 0;


        // 找到一个最小值，然后从后面找到一个最大值，然后计算出最大值减去最小值
        int res = 0, currMin = prices[start];

        for(int sell=start+1; sell<prices.length; sell++) {
            currMin = Math.min(currMin, prices[sell]);
            res = Math.max(res, prices[sell] - currMin);
        }


        return res;
    }
}
