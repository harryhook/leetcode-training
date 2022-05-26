package com.leetcode.training.binarysearch;

public class LeetCode_875_KOKO_Bannas {
    /**
     * 最小速率k吃香蕉， 如果一小时内吃完也得等着下一小时再吃下一堆
     * piles[i] / k， 遍历没堆香蕉吃完要花的时间， K=4，那么假如有3个香蕉，需要1个小时，有4香蕉，还是1个小时，有5个香蕉，就需要两个小时，如果将三种情况融合为一个式子呢，就是用吃速加上香蕉个数减去1，再除以吃速即可
     * 得到 cnt =  (pile + k -1 ) / k , 如果cnt > h, 说明当前k不满足条件
     * 1<= k <= 10^9,
     */
    public int minEatingSpeed(int[] piles, int h) {

        int low = 0, high = 1000000001;

        while (low + 1 != high) {
            int cnt = 0;
            int mid = low + (high - low) / 2;
            for (int pile : piles) {
                cnt += (pile + mid - 1) / mid;
            }
            if (cnt > h) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        LeetCode_875_KOKO_Bannas client = new LeetCode_875_KOKO_Bannas();
        System.out.println(client.minEatingSpeed(new int[]{2,2}, 2));
    }
}
