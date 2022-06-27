package com.leetcode.training.greddy;

public class LeetCode_134_Gas_Station {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        // 找到gas-cost 最小值做为起点， 最后再判断gas 是否大于cost 来判断是否满足题意
        int sum = 0, minSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < minSum) {
                start = i + 1;  // 记录一个可能的点
                minSum = sum;
            }
        }
        // 油不够用，没有正确结果
        if(sum < 0) {
            return -1;
        }
        // 有可能最后一个结点才满足情况
        return start == gas.length? 0 : start;
    }
}
