package com.leetcode.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_300_Longest_Increasing_Subsequence {


    public static void main(String[] args) {
        LeetCode_300_Longest_Increasing_Subsequence client = new LeetCode_300_Longest_Increasing_Subsequence();

        int cnt = client.lengthOfLIS2(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});

        System.out.println(cnt);
    }

    public int lengthOfLIS(int[] nums) {

        int[] length = new int[nums.length];
        Arrays.fill(length, 1);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {
                    length[i] = Math.max(length[j] + 1, length[i]);
                }
            }
            res = Math.max(res, length[i]);

        }
        return res;
    }

    public int lengthOfLIS2(int[] nums) {

        if (nums.length == 1) return 1;

        List<Integer> res = new ArrayList<>();

        res.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {

            if (res.get(res.size() - 1) < nums[i]) {
                res.add(nums[i]);
            } else {

                int low = 0, high = res.size()-1;

                while(low <= high) {
                    int mid = low + (high-low)/2;
                    if(res.get(mid) < nums[i]) {
                        low = mid +1;
                    } else {
                        high = mid -1;
                    }
                }
                res.set(low, nums[i]);
            }
        }
        return res.size();
    }
}
