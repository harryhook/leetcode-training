package com.leetcode.training.backtarcking;


import java.util.ArrayList;
import java.util.List;

/**
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 */
public class LeetCode_216_Combination_Sum_III {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>>  res = new ArrayList<>();

        backTrack( res, new ArrayList<>(), k, n, 1);

        return res;
    }

    private void backTrack( List<List<Integer>>  res, List<Integer> temp, int k, int n, int start) {

        if(temp.size() == k && n == 0) {
            res.add(new ArrayList<>(temp));
            return ;
        }
        if(n < 0 || temp.size() > k) return ;

        for(int i= start; i<=9; i++) {

            temp.add(i);
            backTrack(res, temp, k, n-i, i + 1);
            temp.remove(temp.size()-1);

        }

    }
}
