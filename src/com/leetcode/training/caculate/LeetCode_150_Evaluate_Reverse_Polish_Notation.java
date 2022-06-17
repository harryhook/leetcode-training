package com.leetcode.training.caculate;

import java.util.Stack;

public class LeetCode_150_Evaluate_Reverse_Polish_Notation {
    public static void main(String[] args) {
        LeetCode_150_Evaluate_Reverse_Polish_Notation client = new LeetCode_150_Evaluate_Reverse_Polish_Notation();

        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(client.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public int evalRPN2(String[] tokens) {

        Stack<Integer> nums = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                nums.push(caculate(nums.pop(), nums.pop(), tokens[i]));
            } else {
                nums.push(Integer.parseInt(tokens[i]));
            }
        }
        return nums.pop();
    }

    private int caculate(int b, int a, String ops) {
        switch (ops) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }
}
