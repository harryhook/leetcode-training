package com.leetcode.training.caculate;

import java.util.Stack;

public class LeetCode_224_Basic_Calculator {

    public static void main(String[] args) {
        LeetCode_224_Basic_Calculator client = new LeetCode_224_Basic_Calculator();

        String s = "-2+ 1";
        System.out.println(client.calculate(s));
    }

    /**
     * s consists of digits, '+', '-', '(', ')', and ' '.
     *
     * @param s
     * @return
     */
    public int calculate(String s) {

        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                continue;
            }

            if (Character.isDigit(s.charAt(i))) {
                StringBuilder buffer = new StringBuilder();
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    buffer.append(s.charAt(i++));
                }
                nums.push(Integer.parseInt(buffer.toString()) * sign);
            }
            if (s.charAt(i) == '(') {
                ops.push('(');
            } else if (s.charAt(i) == ')') {
                while (ops.peek() != '(') {
                    nums.push(caculate(nums.pop(), nums.pop(), ops.pop()));
                }
                ops.pop();
            } else {
                while (!ops.isEmpty() && isPriority(s.charAt(i), ops.peek())) {
                    nums.push(caculate(nums.pop(), nums.pop(), ops.pop()));
                }
                ops.push(s.charAt(i));
            }
        }
        while (!ops.isEmpty()) {
            nums.push(caculate(nums.pop(), nums.pop(), ops.pop()));
        }
        return nums.pop();
    }

    private boolean isPriority(char ops1, char ops2) {
        if (ops2 == '(' || ops2 == ')') {
            return false;
        }

        return true;
    }

    private int caculate(int b, int a, Character ops) {
        switch (ops) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
            default:
                return 0;
        }
    }
}