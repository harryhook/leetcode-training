package com.leetcode.training.binarysearch;

import java.util.Objects;

public class FindTarget {


    /**
     * 疑问1： m是否始终处于[0，N)以内？
     * 最小值mid =0, 此时l = -1, r = 0;
     * 最大值mid = n-1, 此时l = n-2, l = n;
     *
     * 疑问2： 会不会出现死循环
     * 举例子 l+3 = r
     * 下一步： l = mid  ==> l+2 = r， 继续循环  l=mid  =>>> l+1 = r
     *
     * @param args
     */
    public static void main(String[] args) {
        double[] nums = {-1, 0, 2, 5, 7.1, 8, 10, 15, 999};
        FindTarget findTarget = new FindTarget();
        System.out.println(findTarget.findTarget(nums, 5, 8));
        System.out.println(findTarget.findTarget(nums, 11, 7.10));
        System.out.println(findTarget.findTarget(nums, 11, 999));


    }
    public int findTarget(double[] nums, int n, double target) {
        if (n <= 0) {
            return -1;
        }
        if (n > nums.length) {
            n = nums.length+1;
        }
        int length = n-1;
        int low = -1, high = length;
        while (low + 1 != high) {
            int mid = low + (high - low) / 2;
            if (Objects.equals(nums[mid], target)) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return -1;
    }
}
