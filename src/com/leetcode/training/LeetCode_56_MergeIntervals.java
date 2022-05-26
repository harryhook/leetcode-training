package com.leetcode.training;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author chenhaowei
 * @date 2020.08.24
 */
public class LeetCode_56_MergeIntervals {

    public static void main(String[] args) {
        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        LeetCode_56_MergeIntervals client = new LeetCode_56_MergeIntervals();

        for (int[] ints : client.merge(nums)) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }


    public int[][] merge(int[][] intervals) {

        int size = intervals.length;
        int[] start = new int[size];
        int[] end = new int[size];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0, j = 0; i < size; i++) {
            if (i == size - 1 || start[i + 1] > end[i]) {
                res.add(new int[]{start[j], end[i]});
                j = i + 1;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
