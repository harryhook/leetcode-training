package com.leetcode.training;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class LeetCode_1306_Jump_Game_III {

    public boolean canReach(int[] arr, int start) {

        Queue<Integer> queue = new LinkedBlockingDeque<>();
        queue.add(start);
        while (!queue.isEmpty()) {

            int i = queue.poll();

            if (arr[i] == -1) continue;

            if (arr[i] == 0) return true;

            if (i - arr[i] >= 0) queue.add(i - arr[i]);

            if (i + arr[i] < arr.length) queue.add(i + arr[i]);

            arr[i] = -1;

        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = {4, 4, 1, 3, 0, 3};
        LeetCode_1306_Jump_Game_III demo = new LeetCode_1306_Jump_Game_III();

        System.out.println(demo.canReach(nums, 2));

    }
}
