package com.leetcode.training;

public class LeetCode_4 {

    public static void main(String[] args) {
        int [] nums1 = {1,3,5,7,9};
        int [] nums2 = {2,4};

        LeetCode_4 client = new LeetCode_4();

        System.out.println( client.findMedianSortedArrays(nums1, nums2));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = nums1.length;

        while (low <= high) {
            int partationX = low + (high - low) / 2;

            int partationY = (x + y + 1) / 2 - partationX;

            int maxLeftX = (partationX == 0) ? Integer.MIN_VALUE : nums1[partationX - 1];
            int minRightX = (partationX == x) ? Integer.MAX_VALUE : nums1[partationX];

            int maxLeftY = (partationY == 0) ? Integer.MIN_VALUE : nums2[partationY - 1];
            int minRightY = (partationY == y) ? Integer.MAX_VALUE : nums2[partationY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partationX - 1;
            } else {
                low = partationX + 1;
            }
        }
        throw new RuntimeException("errror arrays!");
    }
}
