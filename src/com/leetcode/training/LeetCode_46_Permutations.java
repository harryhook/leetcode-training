package com.leetcode.training;

import java.util.ArrayList;
import java.util.Arrays;
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
        if (nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        backTrack(res, nums, new ArrayList<>());

        return res;


    }

    private void backTrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> temp) {

        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i])) {
                    continue;
                }
                temp.add(nums[i]);
                backTrack(res, nums, temp);
                temp.remove(temp.size() - 1);
            }
        }

    }
}
