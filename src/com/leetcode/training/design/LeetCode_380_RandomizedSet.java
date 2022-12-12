package com.leetcode.training.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author haowei.chen
 * @date 2022/11/25 18:06
 * @desc
 */
public class LeetCode_380_RandomizedSet {

    public static void main(String[] args) {
        LeetCode_380_RandomizedSet randomizedSet = new LeetCode_380_RandomizedSet();
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.getRandom());
    }

    static int[] nums = new int[2000000];
    private int size = 0;
    private Map<Integer, Integer> map;

    public LeetCode_380_RandomizedSet() {
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, size);
        nums[size++] = val;
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int loc = map.remove(val);
        if (loc == size - 1) {
            size--;
            return true;
        }
        nums[loc] = nums[--size];
        map.put(nums[loc], loc);
        return true;
    }

    public int getRandom() {
        return nums[new Random().nextInt(size)];
    }
}
