package com.leetcode.training;

public class LeetCode_238_ProductExceptSelf {
        public int[] productExceptSelf(int[] nums) {

            /**
             Numbers:     2    3    4     5
             Lefts:       1    2  2*3 2*3*4
             Rights:  3*4*5  4*5    5     1
             */

            int n = nums.length;
            int[] res = new int[n];

            int left = 1;
            // 先从左往右算一遍
            for(int i=0; i<n; i++) {
                res[i] = left;
                left *= nums[i];
            }

            int right = 1;
            // 再从右往做算一遍
            for(int i = n-1; i>=0; i--) {
                res[i] *= right;
                right *= nums[i];
            }

            return res;


        }
    }