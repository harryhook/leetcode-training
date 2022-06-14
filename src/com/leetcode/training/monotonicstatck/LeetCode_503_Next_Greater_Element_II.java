package com.leetcode.training.monotonicstatck;

import java.util.Stack;

public class LeetCode_503_Next_Greater_Element_II {
    public static void main(String[] args) {
        LeetCode_503_Next_Greater_Element_II client = new LeetCode_503_Next_Greater_Element_II();

        client.nextGreaterElements(new int[]{ 1,2,3,4,3});
    }

    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i=2*n-1; i>=0; i--) {
            while(!s.isEmpty() && s.peek() <= nums[i%n]) {
                s.pop();
            }
            res[i%n] = s.isEmpty()? -1: s.peek();
            s.push(nums[i%n]);
        }
        return  res;
    }
}
