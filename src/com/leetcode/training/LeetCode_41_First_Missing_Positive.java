package com.leetcode.training;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode_41_First_Missing_Positive {


    public static void main(String[] args) {
        LeetCode_41_First_Missing_Positive client = new LeetCode_41_First_Missing_Positive();
        int[] nums = {3,4,-1,1};
        System.out.println(client.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {

            int n = nums.length;


            for(int i=0; i<n; i++) {
                while(nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {
                    swap(nums, i, nums[i]-1);
                }
            }
            for(int i=0; i<n; i++) {
                if(nums[i] != i+1) {
                    return i+1;
                }
            }
            return n+1;

    }

    private void swap(int[] nums, int i, int i1) {
        int temp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = temp;
    }

    public int firstMissingPositive1(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int num : nums) {
            sets.add(num);
        }
        int res = 1;
        while(res <= nums.length) {
            if(!sets.contains(res)) return res;
            res++;
        }
        return res;
    }


}
