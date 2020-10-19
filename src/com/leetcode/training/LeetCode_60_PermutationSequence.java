package com.leetcode.training;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhaowei
 * @date 2020.07.26
 */
public class LeetCode_60_PermutationSequence {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        LeetCode_60_PermutationSequence client = new LeetCode_60_PermutationSequence();

        System.out.println(client.getPermutation(3, 1));
    }

    public String getPermutation(int n, int k) {
        if (n == 0 || k == 0) {
            return "";
        }
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> sub = new ArrayList<>();

        backTrack(res, n, k, 1, sub);
        return res.get(res.size() - 1).toString();
    }

    private void backTrack(List<List<Integer>> res, int n, int k, int start, List<Integer> sub) {

        if (sub.size() == n) {
            res.add(new ArrayList<>(sub));
            if (res.size() == k) {
                return;
            }
        } else {

            for (int i = start; i <= n; i++) {

                sub.add(i);
                backTrack(res, n, k, start + 1, sub);
                sub.remove(sub.size() - 1);
            }
        }

    }
}
