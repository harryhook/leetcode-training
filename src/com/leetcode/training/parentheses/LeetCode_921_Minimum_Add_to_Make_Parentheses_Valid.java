package com.leetcode.training.parentheses;

/**
 * Example 1:
 *
 * Input: s = "())"
 * Output: 1
 * Example 2:
 *
 * Input: s = "((("
 * Output: 3
 *
 * 思路： 以左括号为基准，遇到右括号匹配一次
 * 当右括号次数大于左括号时，累积一次， 并重新匹配
 * 最终计算出 累积个数与所需右括号次数的和
 */
public class LeetCode_921_Minimum_Add_to_Make_Parentheses_Valid {

    public int minAddToMakeValid(String s) {

        int need = 0, res = 0;

        for(int i=0; i<s.length(); i++) {

            if(s.charAt(i) == '(') {
                need++;
            } else {
                need--;
                if(need == -1) {
                    need = 0;
                    res++;
                }
            }
        }
        return need + res;
    }
}
