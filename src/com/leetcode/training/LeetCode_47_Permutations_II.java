package com.leetcode.training;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenhaowei
 * @date 2020.07.26
 */
public class LeetCode_47_Permutations_II {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        LeetCode_47_Permutations_II client = new LeetCode_47_Permutations_II();

        System.out.println(client.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrack(res, nums, new ArrayList<>(), used);

        return res;


    }

    private void backTrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> temp, boolean[] used) {

        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                temp.add(nums[i]);
                backTrack(res, nums, temp, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }

    }
}
