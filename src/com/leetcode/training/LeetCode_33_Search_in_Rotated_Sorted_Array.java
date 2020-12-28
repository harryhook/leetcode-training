package com.leetcode.training;

public class LeetCode_33_Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {

        int[] nums = {8,9,2,3,4};

        LeetCode_33_Search_in_Rotated_Sorted_Array client = new LeetCode_33_Search_in_Rotated_Sorted_Array();

        System.out.println(client.search(nums, 9));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) return target == nums[0] ? 0 : -1;

        int peakIndex = findPeakIndex(nums);

        if (peakIndex >= 0 && target >= nums[0] && target <= nums[peakIndex]) {
            return binarySearch(nums, 0, peakIndex, target);
        } else {
            return binarySearch(nums, peakIndex + 1, nums.length - 1, target);
        }

    }

    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) return target == nums[0] ? 0 : -1;

        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int rotate = low;
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
             int mid = low + (high - low) / 2;
            int realMid = (mid + rotate) % nums.length;
            if (nums[realMid] == target) return realMid;
            if (nums[realMid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int findPeakIndex(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            return nums.length - 1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[left] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return 0;
    }
}
