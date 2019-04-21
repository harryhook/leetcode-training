package com.leetcode.training;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenhaowei
 * @date 2019.03.19
 */
public class LeetCode_1_TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 7};
        int target = 6;
        int[] res = twoSum(nums, target);
        
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int component = target - nums[i];
            if (map.containsKey(component) && map.get(component) != i) {
                return new int[]{i, map.get(component)};
            }
        }
        throw new RuntimeException("No result!");
    }
}
