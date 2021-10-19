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

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (rightNums[i] - leftNums[i] - 1));
        }

        return maxArea;
    }

    private int[] getLeftNum(int[] heights) {
        int[] leftNums = new int[heights.length];
        leftNums[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
               p = leftNums[p];
            }
            leftNums[i] = p;
        }
        return leftNums;
    }

    private int[] getRightNum(int[] heights) {
        int[] rightNums = new int[heights.length];
        rightNums[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < heights.length && heights[p] >= heights[i]) {
                p = rightNums[p];
            }
            rightNums[i] = p;
        }
        return rightNums;
    }
}
