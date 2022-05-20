package com.leetcode.training.binarysearch;

/**
 * Input: nums = [2,2,2,0,1]
 * Output: 0
 * 相比于153， 存在重复元素
 */
public class LeetCode_154_Find_Minimum_in_Rotated_Sorted_Array_II {

    public int findMin(int[] nums) {

        int low = 0, high = nums.length-1;

        while(low < high) {
            int mid = low + (high -low) /2;
            // 最小数肯定在左半区， low=mid+1
            if(nums[mid] > nums[high]) {
                low = mid + 1;
            // 最小数肯定在右半区
            } else if(nums[mid] < nums[high]){
                high = mid;
            } else {
                // 对重复元素进行处理
                high--;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        LeetCode_154_Find_Minimum_in_Rotated_Sorted_Array_II client = new LeetCode_154_Find_Minimum_in_Rotated_Sorted_Array_II();
        System.out.println(client.findMin(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}));
    }
}
