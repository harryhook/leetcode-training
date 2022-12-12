package com.leetcode.training.backtarcking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhaowei
 * @date 2020.07.26
 */
public class LeetCode_46_Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        LeetCode_46_Permutations client = new LeetCode_46_Permutations();

        System.out.println(client.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        dfs(nums,  new ArrayList<>(), res);

        return res;
    }

    private void dfs(int[] nums,  ArrayList<Integer> temp, List<List<Integer>> res) {

        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            dfs(nums,  temp, res);
            temp.remove(temp.size() - 1);
        }

    }
}
