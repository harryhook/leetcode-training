package com.leetcode.training;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_77_Combinations {

    public List<List<Integer>> combinationSum2(int n, int k) {

        if (n == 0 || k == 0) {
        return new ArrayList<>();
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> sol = new ArrayList<>();

    helper(n, k, 0, res, sol);

        return res;
}

    private void helper(int n, int k, int index, List<List<Integer>> res, List<Integer> sol) {
        if (sol.size() == k) {
            res.add(new ArrayList<>(sol));
            return;
        }


        for (int i = index; i < n; i++) {

            sol.add(i+1);
            helper(n, k, i + 1, res, sol);
            sol.remove(sol.size() - 1);
        }
    }

    public static void main(String[] args) {


        LeetCode_77_Combinations client = new LeetCode_77_Combinations();

        System.out.println(client.combinationSum2(4, 2));
    }

}