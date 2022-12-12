package com.leetcode.training;


import java.util.Deque;
import java.util.LinkedList;

public class LeetCode_1696_Jump_Game_VI {

    public static void main(String[] args) {
        LeetCode_1696_Jump_Game_VI client = new LeetCode_1696_Jump_Game_VI();

        int res = client.maxResult1(new int[]{1, -1, -2, 4, -7, 3}, 2);

        System.out.println(res);
    }

    public int maxResult(int[] nums, int k) {

        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            // 找到 i-k < j < i 的最大dp
            int currMax = Integer.MIN_VALUE;
            for (int j = i - k < 0 ? 0 : i - k; j < i; j++) {
                currMax = Math.max(dp[j], currMax);
            }
            dp[i] = nums[i] + currMax;
        }
        return dp[n - 1];
    }


    public int maxResult1(int[] nums, Integer k) {

        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> queue = new LinkedList<>();
        dp[0] = nums[0];
        queue.offerFirst(0);
        for (int i = 1; i < n; i++) {

            while (!queue.isEmpty() && i - k > queue.peekFirst()) {
                queue.pollFirst();
            }

            dp[i] = nums[i] + dp[queue.peekFirst()];

            while (!queue.isEmpty() && dp[i] >= dp[queue.peekLast()]) {
                queue.pollLast();
            }

            queue.offerLast(i);
        }
        return dp[n - 1];
    }


    public int maxResult2(int[] nums, Integer k) {

        Deque<Pair<Integer, Integer>> deque = new LinkedList<Pair<Integer, Integer>>() {{
            offer(new Pair<>(0, nums[0]));
        }};
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst().getKey() < i - k) {
                deque.pollFirst();
            }

            max = nums[i] + (deque.isEmpty() ? 0 : deque.peekFirst().getValue());

            while (!deque.isEmpty() && deque.peekLast().getValue() <= max) {
                deque.pollLast();
            }

            deque.offerLast(new Pair<>(i, max));
        }

        return max;
    }
}

class Pair<K, V> {

    private Integer key;

    private Integer value;

    public <K, V> Pair(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
