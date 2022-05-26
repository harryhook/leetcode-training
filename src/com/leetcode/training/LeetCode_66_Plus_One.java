package com.leetcode.training;

import java.util.Arrays;

/**
 * @author chenhaowei
 * @date 2020.11.14
 */
public class LeetCode_66_Plus_One {


    public static void main(String[] args) {
        LeetCode_66_Plus_One client = new LeetCode_66_Plus_One();
        for (int i : client.plusOne(new int[]{8,9,9})) {
            System.out.println(i);
        }
    }

    public int[] plusOne(int[] digits) {
        if(digits.length == 0) return digits;
        int carry = 1;
        for(int i = digits.length-1; i>=0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }
        if(carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            for(int i=1; i<=digits.length; i++) {
                result[i] = digits[i-1];
            }
        }
        return digits;
    }

}
