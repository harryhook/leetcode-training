package com.leetcode.training.prefix.array;

/**
 * @author haowei.chen
 * @date 2022/11/19 00:01
 * @desc
 */
public class LeetCode_1109_CorpFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference diff = new Difference(nums);

        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int value = booking[2];

            diff.increase(i, j, value);
        }

        return diff.res();
    }

    public static void main(String[] args) {
        LeetCode_1109_CorpFlightBookings client = new LeetCode_1109_CorpFlightBookings();
        int[][] bookings = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        int[] res = client.corpFlightBookings(bookings, n);
        for (int index = 0; index < res.length; index++) {
            System.out.print(res[index] + " ");
        }
    }
}

class Difference {

    private int[] diffs;

    public Difference(int[] nums) {
        diffs = new int[nums.length];
        diffs[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diffs[i] = nums[i] - nums[i - 1];
        }
    }


    public void increase(int i, int j, int value) {
        diffs[i] += value;
        if (j+1 < diffs.length) {
            diffs[j+1] -= value;
        }
    }


    public int[] res() {
        int[] res = new int[diffs.length];
        res[0] = diffs[0];
        for (int i = 1; i < diffs.length; i++) {
            res[i] = res[i - 1] + diffs[i];
        }
        return res;
    }
}
