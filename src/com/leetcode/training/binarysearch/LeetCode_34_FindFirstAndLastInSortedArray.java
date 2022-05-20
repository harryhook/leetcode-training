package com.leetcode.training.binarysearch;

public class LeetCode_34_FindFirstAndLastInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};

        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);

        return res;
    }
    private int findFirst(int[] nums, int target) {
        int low = -1, high = nums.length;
        while(low + 1 != high) {
            int mid = low + (high-low) / 2;
            if(nums[mid]<target) {
                low = mid ;
            } else {
                high = mid;
            }
        }
        if(high == nums.length) return -1;
        return nums[high] == target? high:-1;
    }

    private int findLast(int[] nums, int target) {
        int low = -1, high = nums.length;
        while(low + 1 != high) {
            int mid = low + (high-low) / 2;
            if(nums[mid]>target) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if(low == -1) return -1;
        return nums[low] == target? low:-1;
    }

    public static void main(String[] args) {
        LeetCode_34_FindFirstAndLastInSortedArray client = new LeetCode_34_FindFirstAndLastInSortedArray();

        client.searchRange(new int[]{5,7,7,8,8,10}, 8);
    }
}
