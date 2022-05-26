package com.leetcode.training;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhaowei
 * @date 2020.07.26
 */
public class LeetCode_60_PermutationSequence {

    /**
     * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * Given n and k, return the kth permutation sequence.
     * Example 1:
     * Input: n = 3, k = 3
     * Output: "213"
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        LeetCode_60_PermutationSequence client = new LeetCode_60_PermutationSequence();

        System.out.println(client.getPermutation(4, 24));
    }

    /*   n 个数字会生成 n！个排列， 以n=4为例，会生成 24 个数字 排列，n 个数字的排列为： 1, 1，2，6，24，100...
        思路: n = 4, k=9  9/4 = 2 余 1
      */
    public String getPermutation(int n, int k) {

        List<Integer> nums = new ArrayList<>();
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
            nums.add(i);
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(nums.get(index));
            nums.remove(index);
            k -= index * factorial[n - i];
        }
        return sb.toString();
    }
}
