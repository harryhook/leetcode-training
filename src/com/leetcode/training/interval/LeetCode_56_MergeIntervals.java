package com.leetcode.training.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author chenhaowei
 * @date 2020.08.24
 */
public class LeetCode_56_MergeIntervals {

    public static void main(String[] args) {
        int[][] nums = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};

        LeetCode_56_MergeIntervals client = new LeetCode_56_MergeIntervals();

        for (int[] ints : client.merge1(nums)) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

    public int[][] merge1(int[][] intervals) {

        int size = intervals.length;
        if(size == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < size; i++) {
            int[] cur = intervals[i];
            int[] pre = res.get(res.size() - 1);
            if (pre[1] < cur[0]) {
                res.add(cur);
            } else {
                pre[1] = Math.max(pre[1], cur[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
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
