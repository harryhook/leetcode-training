package com.leetcode.training;

public class LeetCode_84_Largest_Rectangle_in_Histogram {

    public static void main(String[] args) {
        LeetCode_84_Largest_Rectangle_in_Histogram client = new LeetCode_84_Largest_Rectangle_in_Histogram();
        int[] nums = {2, 1, 5, 6, 2, 3};
        client.largestRectangleArea(nums);

    }

    public int largestRectangleArea(int[] heights) {

        int[] leftNums = getLeftNum(heights);
        int[] rightNums = getRightNum(heights);


        return -1;
    }

    private int[] getLeftNum (int[] heights) {
        int[] leftNums = new int[heights.length];

        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p--;
            }
            leftNums[i] = p;
        }
        return leftNums;
    }

    private int[] getRightNum(int[] heights) {
        int[] rightNums = new int[heights.length];

        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p <= heights.length - 1 && heights[p] >= heights[i]) {
                p++;
            }
            rightNums[i] = p;
        }
        return rightNums;
    }
}
