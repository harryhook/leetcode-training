package com.leetcode.training.binarysearch;

/**
 * Input: nums = [2,2,2,0,1]
 * Output: 0
 * 相比于153， 存在重复元素
 */
public class LeetCode_154_Find_Minimum_in_Rotated_Sorted_Array_II {

    public int findMin(int[] nums) {
        int length = nums.length;
        int low = -1, high = length-1;
        int lastVal = nums[length-1];
        while(low + 1 != high) {
            int mid = low + (high -low) /2;
            if(nums[mid] <= lastVal) {
                high = mid;
            } else{
                low = mid;
            }
        }
        return nums[high];
    }
}
