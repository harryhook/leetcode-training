package com.leetcode.training;

public class LeetCode_1013_Partition_Array_Into_Three_Parts_With_Equal_Sum {

    public static void main(String[] args) {

        LeetCode_1013_Partition_Array_Into_Three_Parts_With_Equal_Sum client = new LeetCode_1013_Partition_Array_Into_Three_Parts_With_Equal_Sum();

        System.out.println(client.canThreePartsEqualSum(new int[]{0,0,0,0}));
    }

    public boolean canThreePartsEqualSum(int[] arr) {

        if (arr.length == 0) return false;

        int len = arr.length;
        int[] preSum = new int[len];
        preSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }

        if (preSum[len - 1] % 3 != 0) return false;

        int first = -1, second = -1;
        int part = preSum[len - 1] / 3;
        for (int i = 0; i < len; i++) {
            if (preSum[i] == part) {
                first = i;
                break;
            }

        }

        for (int i = first + 1; i < len; i++) {
            if (preSum[i] == 2*part) {
                second = i;
                break;
            }
        }

        return first != -1 && second != -1 && second != len - 1;

    }
}
