package com.leetcode.training;

/**
 * @author chenhaowei
 * @date 2020.11.14
 */
public class LeetCode_67_Add_Binary {


    public static void main(String[] args) {
        LeetCode_67_Add_Binary client = new LeetCode_67_Add_Binary();
        System.out.printf(client.addBinary("111", "110"));
    }

    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int i = a.length() - 1,j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }


        return sb.reverse().toString();
    }

}
