package com.leetcode.training.backtarcking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhaowei
 * @date 2020.07.26
 */
public class LeetCode_90_Subset_II {

    public static void main(String[] args) {

        LeetCode_90_Subset_II client = new LeetCode_90_Subset_II();
        int[] nums = {1,2,2};

        System.out.println(client.subsets(nums));

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backTrack(res, nums, new ArrayList<>(), 0);

        return res;
    }

    private void backTrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> temp, int start) {

        res.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            // 剪枝逻辑，值相同的相邻树枝，只遍历第一条
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            backTrack(res, nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
