package com.leetcode.training.parentheses;


/**
 * Example 1:
 *
 * Input: s = "(()))"
 * Output: 1
 * Explanation: The second '(' has two matching '))', but the first '(' has only ')' matching. We need to add one more ')' at the end of the string to be "(())))" which is balanced.
 * Example 2:
 *
 * Input: s = "())"
 * Output: 0
 * Explanation: The string is already balanced.
 * Example 3:
 *
 * Input: s = "))())("
 * Output: 3
 * Explanation: Add '(' to match the first '))', Add '))' to match the last '('.
 *
 * 一个左括号需要两个右括号来平衡
 */
public class LeetCode_1541_Minimum_Insertions_to_Balance_a_Parentheses_String {

    public int minInsertions(String s) {
        int need = 0, res = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                need = need + 2;
                if(need % 2 == 1) {
                    // 当遇到左括号而右括号格式为奇数个， 需要新增一个右括号
                    res++;
                    need--;
                }
            } else {
                need--;
                if(need == -1) {
                    // 多了一个右括号，需要新增一个左括号， 同时还加一个右括号
                    need = 1;
                    res++;
                }
            }
        }
        return res + need;
    }

}
