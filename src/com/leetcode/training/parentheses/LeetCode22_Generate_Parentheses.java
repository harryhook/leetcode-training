package com.leetcode.training.parentheses;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22_Generate_Parentheses {
    public static void main(String[] args) {
        LeetCode22_Generate_Parentheses client = new LeetCode22_Generate_Parentheses();

        List<String> res = client.generateParenthesis(3);
        System.out.println(res);
    }

    public List<String> generateParenthesis(int n) {

        if(n == 0) return new ArrayList<>();

        List<String>  res = new ArrayList<>();

        helper(n, n , res, new StringBuilder());

        return res;
    }

    // 可用的左括号数量为 left 个，可用的右括号数量为 right 个
    private void helper(int left, int right, List<String> res, StringBuilder temp) {
        // 左括号比右括号多， 不合法
        if (right < left) return;
        // 有一方的括号用完了，不合法
        if (left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            res.add(temp.toString());
            return;
        }


        helper(left-1, right, res, temp.append("("));
        temp.deleteCharAt(temp.length() - 1);
        // 再加右括号
        helper(left, right-1, res, temp.append(")"));
        temp.deleteCharAt(temp.length() - 1);
    }
}
