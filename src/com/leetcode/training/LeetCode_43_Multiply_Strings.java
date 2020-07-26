package com.leetcode.training;

public class LeetCode_43_Multiply_Strings {


    public static void main(String[] args) {
        LeetCode_43_Multiply_Strings client = new LeetCode_43_Multiply_Strings();

        System.out.printf(client.multiply("123", "456"));

    }

    public String multiply(String num1, String num2) {

        int m = num1.length();
        int n = num2.length();

        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + pos[i + j + 1];
                pos[i + j + 1] = sum % 10;
                pos[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int sum : pos) {
            if (!(sb.length() == 0 && sum == 0)) {
                sb.append(sum);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
