package com.leetcode.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_40_Combination_Sum_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {


        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();

        helper(candidates, 0, target, res, sol);

        return res;
    }

    private void helper(int[] candidates, int index, int target, List<List<Integer>> res, List<Integer> sol) {
        if (target == 0) {
            res.add(new ArrayList<>(sol));
            return;
        }
        if (target < 0 || index == candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sol.add(candidates[i]);
            helper(candidates, i + 1, target - candidates[i], res, sol);
            sol.remove(sol.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};

        LeetCode_40_Combination_Sum_II client = new LeetCode_40_Combination_Sum_II();

        System.out.println(client.combinationSum2(candidates, 8));
    }

}