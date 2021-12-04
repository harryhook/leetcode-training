package com.leetcode.training;

public class QuikcSort {


    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 2, 1, 6};
        QuikcSort quikcSort = new QuikcSort();
        System.out.println(quikcSort.findKthLargest(nums, 2));


    }

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = sort(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    public void quickSort(int[] nums) {
        int low = 0;
        int high = nums.length - 1;


        sort(nums, low, high);
    }

    private int sort(int[] nums, int low, int high) {
        if (low < high) {
            int curr = nums[low];
            int i = low, j = high;
            while (i < j) {

                while (i < j && nums[j] > curr) j--;
                if (i < j) nums[i++] = nums[j];

                while (i < j && nums[i] < curr) i++;
                if (i < j) nums[j--] = nums[i];
            }
            nums[i] = curr;

            return i;
        }
        return -1;

    }

    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while (true) {
            while (i < hi && less(a[++i], a[lo])) ;
            while (j > lo && less(a[lo], a[--j])) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    private boolean less(int i, int j) {
        return i < j;
    }
}
