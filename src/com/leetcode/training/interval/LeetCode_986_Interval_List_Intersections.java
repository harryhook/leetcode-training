package com.leetcode.training.interval;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_986_Interval_List_Intersections {

    public static void main(String[] args) {
        LeetCode_986_Interval_List_Intersections client = new LeetCode_986_Interval_List_Intersections();

        int[][] firstList = new int[][]{{8, 15}};
        int[][] secondList = new int[][]{{2, 6}, {8, 10}, {12, 20}};

        client.intervalIntersection(firstList, secondList);
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        // 不相交的情况
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;

        int length1 = firstList.length, length2 = secondList.length;

        while (i < length1 && j < length2) {
            int[] a = firstList[i];
            int[] b = secondList[j];


            int low = Math.max(a[0], b[0]);
            int high = Math.min(a[1], b[1]);
            if (low <= high) {
                res.add(new int[]{low, high});
            }
            if (a[1] < b[1]) {
                i++;
            } else {
                j++;
            }

        }

        return res.toArray(new int[0][]);

    }
}
