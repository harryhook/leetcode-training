package com.leetcode.training.slidewindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_239_Sliding_Window_Maximum {


    public static void main(String[] args) {

        LeetCode_239_Sliding_Window_Maximum client = new LeetCode_239_Sliding_Window_Maximum();

        int[] res = client.maxSlidingWindow1(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

        for (int n : res) {
            System.out.println(n);
        }

    }

    public int[] maxSlidingWindow1(int[] nums, int k) {

        // 核心思想，滑动窗口， peekFirst 是当前区间的最大值, pollFirst 限定当前区间的元素， pollLast 给最大元素让位置

        int n = nums.length;

        int[] res = new int[n - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {

            while (!queue.isEmpty() && i - k + 1 > queue.peekFirst()) {
                queue.pollFirst();
            }

            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }

            queue.offerLast(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        MaxQueue queue = new MaxQueue();

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {

            if(i<k-1) {
                queue.push(nums[i]);
            } else {
                queue.push(nums[i]);
                list.add(queue.getMax());
                queue.pop(nums[i-k+1]);
            }
        }
        int[] res = new int[nums.length-k+1];
        for(int i=0; i<nums.length-k+1; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
class MaxQueue {

    LinkedList<Integer> queue = new LinkedList<>();

    public void push(int n) {
        while(!queue.isEmpty() && queue.peekLast() < n) {
            queue.pollLast();
        }
        queue.offerLast(n);
    }

    public Integer getMax() {
        return queue.peekFirst();
    }
    public void pop(int n) {
        if(n == queue.peekFirst()) {
            queue.pollFirst();
        }
    }
}
