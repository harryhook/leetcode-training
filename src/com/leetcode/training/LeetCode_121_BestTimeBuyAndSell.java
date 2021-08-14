package com.leetcode.training;

public class LeetCode_121_BestTimeBuyAndSell {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int maxCur = 0, res = 0;

        for (int i = 1; i < prices.length; i++) {
            maxCur += prices[i] - prices[i - 1];
            maxCur = Math.max(0, maxCur);
            res = Math.max(res, maxCur);
        }
        return res;
    }
}
