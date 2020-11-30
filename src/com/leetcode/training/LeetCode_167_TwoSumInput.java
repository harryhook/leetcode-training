package com.leetcode.training;

/**
 * @author chenhaowei
 * @date 2020.11.17
 */
public class LeetCode_167_TwoSumInput {


    public static void main(String[] args) {
        LeetCode_167_TwoSumInput client = new LeetCode_167_TwoSumInput();
        int[] nums = {2, 3, 4};
        int[] res = client.twoSum(nums, 6);

        System.out.printf(res[0] + "" + res[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int length = numbers.length;
        for (int i = 0; i < length; i++) {

            int left = i+1, right = length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target - numbers[i] == numbers[mid] && i != mid) {
                    ans[0] = i + 1;
                    ans[1] = mid + 1;
                    break;
                } else if (target - numbers[i] > numbers[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return ans;
    }
}
