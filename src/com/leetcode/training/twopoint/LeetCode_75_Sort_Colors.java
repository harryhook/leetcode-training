package com.leetcode.training.twopoint;

public class LeetCode_75_Sort_Colors {

    public static void main(String[] args) {
        LeetCode_75_Sort_Colors client = new LeetCode_75_Sort_Colors();

        for (int num : client.sortColors(new int[]{1,1,1,1, 2, 0, 1})) {
            System.out.println(num);
        }
    }

    public int[] sortColors(int[] nums) {
        int n = nums.length;
        int pos = -1; //等于0的最后位置
        int neg = n;  //等于2的最前位置
        int idx = 0;
        while (idx < nums.length) {
            if (nums[idx] == 1) {
                idx++;
            } else if (nums[idx] == 0) {
                //等于0 则与首部交换
                swap(nums, ++pos, idx++);
            } else if (nums[idx] == 2) {
                //等于2 则与尾部交换,idx不++，因为此时换来的还没有进行判断
                swap(nums, --neg, idx);
            }
            if (idx == neg) break;
        }
        return nums;
    }

    public static void swap(int[] arr, int m, int n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }
}
