package com.leetcode.training.caculate;

import java.util.Stack;

public class InfixExpr {

    /**
     * 给定一个字符串  "2+3*4+5" 求结果
     */

    public static void main(String[] args) {
        InfixExpr infixExpr = new InfixExpr();
        System.out.println(infixExpr.infixCaculate("2+4/2+5"));
    }

    private int infixCaculate(String s) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            if ( s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    sb.append(s.charAt(i++));
                }
                s1.push(Integer.parseInt(sb.toString()));
                i--;
            }
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                s2.push(s.charAt(i));
            }
            if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                s2.push(s.charAt(i));
                sb = new StringBuilder();
                if (s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9') {
                    while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                        sb.append(s.charAt(++i));
                    }
                    int next = Integer.parseInt(sb.toString());
                    s1.push(caculate( next, s1.pop(), s2.pop()));
                }
            }
        }
        while (!s2.isEmpty()) {
            s1.push(caculate(s1.pop(), s1.pop(), s2.pop()));
        }
        return s1.pop();
    }

    private Integer caculate(Integer b, int a, char charAt) {

        if (charAt == '+') {
            return a + b;
        } else if (charAt == '-') {
            return a - b;
        } else if (charAt == '*') {
            return a * b;
        } else if (charAt == '/') {
            if (b == 0) throw new RuntimeException("illeagle nums!");
            return a / b;
        }
        return -1;
    }

}
