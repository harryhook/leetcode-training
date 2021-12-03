package com.leetcode.training;

import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode_215_Kth_Largest_Element_in_an_Arra {

    public static void main(String[] args) {
        LeetCode_215_Kth_Largest_Element_in_an_Arra client = new LeetCode_215_Kth_Largest_Element_in_an_Arra();

        System.out.println(client.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if(queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }
}
