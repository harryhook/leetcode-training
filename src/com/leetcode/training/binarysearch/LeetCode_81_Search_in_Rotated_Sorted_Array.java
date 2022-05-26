package com.leetcode.training.binarysearch;

public class LeetCode_81_Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {

        int[] nums = {2,5,6,0,0,1,2};

        LeetCode_81_Search_in_Rotated_Sorted_Array client = new LeetCode_81_Search_in_Rotated_Sorted_Array();

        System.out.println(client.search1(nums, 3));
    }
    public boolean search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) return target == nums[0] ? true : false;

        int low = -1;
        int high = nums.length;

        while (low + 1 != high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if(nums[mid] < target) {

            }
        }
        return false;
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) return target == nums[0] ? true : false;


        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            } else if (nums[low] <= nums[mid]) {

                if (nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return false;

    }

}