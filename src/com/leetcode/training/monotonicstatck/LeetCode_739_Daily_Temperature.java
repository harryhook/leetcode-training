package com.leetcode.training.monotonicstatck;

import java.util.Stack;

/**
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 */
public class LeetCode_739_Daily_Temperature {
    public int[] dailyTemperatures(int[] temperatures) {

        // 单调栈，数组元素与栈顶元素比较
        Stack<Integer> s = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }
            // 得到索引间距
            res[i] = s.isEmpty() ? 0 : (s.peek() - i);
            // 将索引入栈，而不是元素
            s.push(i);
        }
        return res;
    }
}
