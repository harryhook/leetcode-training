package com.leetcode.training;

import java.util.*;

public class LeetCode_347_Top_K_Frequent_Elements {


    public static void main(String[] args) {
        LeetCode_347_Top_K_Frequent_Elements client = new LeetCode_347_Top_K_Frequent_Elements();

        int [] nums = new int[] {1,1,1,2,2,3};
       List<Integer> res = client.topKFrequent(nums, 2);

        for (int num : res) {
            System.out.println(num);
        }

    }
    public List<Integer>  topKFrequent(int[] nums, int k) {

        if(nums.length == 0 || k <= 0) {
            return  new ArrayList<>();
        }

        Map<Integer, Integer> maps = new HashMap<>();

        for (int num : nums) {
            maps.put(num, maps.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length+1];

        for(int key: maps.keySet()) {
            int frequency = maps.get(key);
            if(bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        List<Integer> res = new ArrayList<>();

        for(int pos = bucket.length-1; pos>=0 && res.size() < k; pos--) {
            if(bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
            if (res.size() >= k) break;
        }


        return res;
    }
}
