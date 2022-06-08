package com.leetcode.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_349_Intersection_of_Two_Arrays {

    public static void main(String[] args) {

        LeetCode_349_Intersection_of_Two_Arrays client = new LeetCode_349_Intersection_of_Two_Arrays();

        System.out.println(client.intersection(new int[]{1,2,2,1}, new int[]{1,1}));

    }

    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1.length == 0 || nums2.length == 0) return new int[]{};

        int p1 = 0, p2 = 0;
        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (p1 < nums1.length && p2 < nums2.length) {
            // 双指针
            if (nums1[p1] == nums2[p2]) {
                if (!res.isEmpty() && res.get(res.size() - 1) == nums1[p1]) {
                    p1++;
                    p2++;
                    continue;
                }
                res.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }

        }
        int[] resNum = new int[res.size()];
        for(int i=0; i<res.size(); i++) {
            resNum[i] = res.get(i);
        }

        return resNum;
    }
}
