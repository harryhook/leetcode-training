package com.leetcode.training.binarysearch;

public class LeetCode_153_Find_Minimum_in_Rotated_Sorted_Array {
    public static void main(String[] args) {

        int[] nums = {2, 5, 6, 0, 1, 3};

        LeetCode_153_Find_Minimum_in_Rotated_Sorted_Array client = new LeetCode_153_Find_Minimum_in_Rotated_Sorted_Array();

        System.out.println(client.findMin(nums));
    }

    public int findMin(int[] nums) {
        int length = nums.length;
        int low = -1, high = length;
        int lastVal = nums[length - 1];
        while (low + 1 != high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= lastVal) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return nums[high];
    }
}
