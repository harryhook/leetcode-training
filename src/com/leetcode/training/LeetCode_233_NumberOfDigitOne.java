package com.leetcode.training;

public class LeetCode_233_NumberOfDigitOne {

    public int countDigitOne(int n) {

        if(n == 0) return 0;

        if (n < 10) return 1;

        int res = 0;
        int base = 1;
        while (base <= n) {
            int left = n / base / 10;
            int right = n % base;
            int cur = n / base % 10;

            if (cur == 0) {
                res += left * base;
            } else if (cur > 1) {
                res += (left + 1) * base;
            } else if (cur == 1) {
                res += left * base + right + 1;
            }

            base *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_233_NumberOfDigitOne client = new LeetCode_233_NumberOfDigitOne();
        System.out.println(client.countDigitOne(21012));
    }

}
