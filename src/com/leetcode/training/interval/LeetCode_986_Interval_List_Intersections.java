package com.leetcode.training.interval;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_986_Interval_List_Intersections {

    public static void main(String[] args) {
        LeetCode_986_Interval_List_Intersections client = new LeetCode_986_Interval_List_Intersections();

        int[][] firstList = new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}};

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


            if (a[0] <= b[1] && b[0] <= a[1]) {
                int[] temp = new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])};
                res.add(temp);
                if(a[0] < b[1]) {
                    i++;
                } else {
                    j++;
                }
            } else  if (a[1] < b[1]) {
                i++;
            } else if (a[1] > b[1]) {
                j++;
            }
        }

        int[][] resArr = new int[res.size()][2];
        for (int k = 0; k < res.size(); k++) {
            resArr[k][0] = res.get(k)[0];
            resArr[k][1] = res.get(k)[1];
        }
        return resArr;
    }
}
