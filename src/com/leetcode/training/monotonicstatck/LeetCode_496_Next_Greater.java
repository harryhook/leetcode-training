package com.leetcode.training.monotonicstatck;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode_496_Next_Greater {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int []res = new int[nums1.length];

        int[] greaterEle = new int[nums2.length];

        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=nums2.length-1; i>=0; i--) {

            while(!s.isEmpty() && s.peek() <= nums2[i]) {
                s.pop();
            }
            greaterEle[i] = s.isEmpty()? -1: s.peek();
            map.put(nums2[i], greaterEle[i]);
            s.push(nums2[i]);

        }

        for(int j=0; j<nums1.length; j++) {
            res[j] = map.get(nums1[j]);
        }
        return res;
    }
}
