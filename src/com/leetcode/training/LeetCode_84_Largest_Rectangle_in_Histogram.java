package com.leetcode.training;

import java.util.Stack;

public class LeetCode_84_Largest_Rectangle_in_Histogram {

    public static void main(String[] args) {
        LeetCode_84_Largest_Rectangle_in_Histogram client = new LeetCode_84_Largest_Rectangle_in_Histogram();
        int[] nums = {2, 1, 5, 6, 2, 3};
        System.out.println(client.largestRectangleArea(nums));

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

    public int largestRectangleArea2(int[] heights) {
        Stack<Integer> s = new Stack<>();

        int maxArea = 0; // Initialize max area
        int top;  // To store top of stack
        int currAreaWithTop; // To store area with top bar as the smallest bar
        int n = heights.length;
        // Run through all bars of given histogram
        int i = 0;
        while (i < n) {
            // If this bar is higher than the bar on top stack, push it to stack
            if (s.empty() || heights[s.peek()] <= heights[i])
                s.push(i++);

                // If this bar is lower than top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before top in stack is 'left index'
            else {
                top = s.pop();  // pop the top

                if (s.isEmpty()) {
                    currAreaWithTop = heights[top] * i;
                } else {
                    currAreaWithTop = heights[top] * i - s.peek() - 1;
                }
                maxArea = Math.max(maxArea, currAreaWithTop);
            }
        }

        while (!s.isEmpty()) {
            top = s.pop();
            if (s.isEmpty()) {
                currAreaWithTop = heights[top] * i;
            } else {
                currAreaWithTop = heights[top] * i - s.peek() - 1;
            }
            maxArea = Math.max(maxArea, currAreaWithTop);

        }

        return maxArea;

    }
}
