package com.leetcode.training;

import java.util.Arrays;

public class LeetCode_189_RotateArray {

    public static void main(String[] args) {

        LeetCode_189_RotateArray leetCode_189_rotateArray = new LeetCode_189_RotateArray();

        leetCode_189_rotateArray.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 7);
    }

    public void rotate(int[] nums, int k) {

        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
