package com.leetcode.training;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author chenhaowei
 * @date 2020.10.19
 */
public class LeetCode_57_Insert_Interval {

    public static void main(String[] args) {
        LeetCode_57_Insert_Interval client = new LeetCode_57_Insert_Interval();
       int [][]res =  client.insert(new int[][]{{1,6},{9,14}}, new int[]{8,11,17});

        for (int[] ints : res) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int size = intervals.length + 1;
        int[] start = new int[size];
        int[] end = new int[size];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        start[size - 1] = newInterval[0];
        end[size - 1] = newInterval[1];

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
