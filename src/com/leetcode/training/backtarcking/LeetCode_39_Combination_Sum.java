package com.leetcode.training.backtarcking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_39_Combination_Sum {

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();

        backTrack(nums, res, new ArrayList<>(), 0, target);

        return res;
    }

    private void backTrack(int[] nums, List<List<Integer>> res, List<Integer> temp, int start, int target) {

        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backTrack(nums, res, temp, i, target - nums[i]);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode_39_Combination_Sum client = new LeetCode_39_Combination_Sum();
        System.out.println(client.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
