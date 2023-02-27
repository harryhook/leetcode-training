package com.leetcode.training;

import java.util.Arrays;

/**
 * @author haowei.chen
 * @date 2023/2/11 17:12
 * @desc
 */
public class LeetCode_2335_FillCups {

    public static void main(String[] args) {
        LeetCode_2335_FillCups client = new LeetCode_2335_FillCups();
        int result = client.fillCups(new int[]{5, 4, 4});
        System.out.println(result);
    }

    public int fillCups(int[] amount) {

        int res = 0;
        while (amount[0] + amount[1] + amount[2] > 0) {

            Arrays.sort(amount);

            if (amount[2] > 0) {
                amount[2]--;
            }
            if (amount[1] > 0) {
                amount[1]--;
            }
            res++;

        }
        return res;
    }

}



