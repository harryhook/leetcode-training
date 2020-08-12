package com.leetcode.training;

/**
 * @author chenhaowei
 * @date 2020.08.06
 */
public class LeetCode_50_My_Pow {

    public static void main(String[] args) {
        LeetCode_50_My_Pow client = new LeetCode_50_My_Pow();
        client.pow(2.5, 2);
    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
    }
}
