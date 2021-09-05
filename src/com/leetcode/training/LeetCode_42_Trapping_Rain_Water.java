package com.leetcode.training;

public class LeetCode_42_Trapping_Rain_Water {

    public static void main(String[] args) {

        LeetCode_42_Trapping_Rain_Water client = new LeetCode_42_Trapping_Rain_Water();
        int[] heights = {4, 2, 0, 6, 2, 3, 5};

        System.out.println(client.trap(heights));

    }

    public int trap(int[] height) {

        if (height.length < 2) return 0;

        int n = height.length;
        int[] maxLeftHelp = new int[n];
        int[] maxRightHelp = new int[n];
        int leftMax = height[0];
        int rightMax = height[n - 1];
        for (int i = 1, j = n - 2; i < n && j >= 0; i++, j--) {

            maxLeftHelp[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);

            maxRightHelp[j] = rightMax;
            rightMax = Math.max(rightMax, height[j]);
        }

        int water = 0;
        for (int i = 1; i < n - 1; i++) {
            if (height[i] < maxLeftHelp[i] && height[i] < maxRightHelp[i]) {
                water += Math.min(maxLeftHelp[i], maxRightHelp[i]) - height[i];
            }
        }
        return water;
    }
}
