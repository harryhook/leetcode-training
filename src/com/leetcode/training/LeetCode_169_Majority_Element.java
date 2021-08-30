package com.leetcode.training;

public class LeetCode_169_Majority_Element {

    public int majorityElement(int[] nums) {

        int[] bit = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                bit[j] += (nums[i] >> j) & 1;
            }
        }
        int majority = 0;
        for (int j = 0; j < 32; j++) {
            bit[j] = bit[j] > (nums.length / 2)? 1 : 0;
            majority += bit[j] << j;
        }
        return majority;
    }

    public static void main(String[] args) {
        LeetCode_169_Majority_Element client = new LeetCode_169_Majority_Element();

        int[] nums = {3, 3, 4};
        System.out.println(client.majorityElement(nums));

    }
}
