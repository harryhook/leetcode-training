package com.leetcode.training.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_33_Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {

        int[] nums = {8, 9, 0, 2, 3, 4};

        LeetCode_33_Search_in_Rotated_Sorted_Array client = new LeetCode_33_Search_in_Rotated_Sorted_Array();

        System.out.println(client.allResult(new int[]{1, 2, 3}));
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
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;

            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[mid] <= nums[right]) {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
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

    private List<List<Integer>> allResult(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums);
        return res;
    }

    private void helper(List<List<Integer>> res, ArrayList<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                helper(res, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }


    }
}
