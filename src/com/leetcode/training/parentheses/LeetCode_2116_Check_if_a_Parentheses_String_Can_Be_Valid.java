package com.leetcode.training.parentheses;

/**
 * Input: s = "))()))", locked = "010100"
 * Output: true
 * Explanation: locked[1] == '1' and locked[3] == '1', so we cannot change s[1] or s[3].
 * We change s[0] and s[4] to '(' while leaving s[2] and s[5] unchanged to make s valid.
 * Example 2:
 * <p>
 * Input: s = "()()", locked = "0000"
 * Output: true
 * Explanation: We do not need to make any changes because s is already valid.
 * Example 3:
 * <p>
 * Input: s = ")", locked = "0"
 * Output: false
 * Explanation: locked permits us to change s[0].
 * Changing s[0] to either '(' or ')' will not make s valid.
 * <p>
 * 思路： res 表示当前多余左括号的数量， 将可变位置的括号替换为右括号
 * 回顾判断括号序列是否合法：初始化变量 x:=0，表示当前多余的左括号的数量。如果当位置为左括号，则 x=x+1；否则 x=x−1。
 * 如果中途 x<0，则说明遇到了多余的右括号，则不是合法的括号序列。如果最终 x=0，则说明是合法的括号序列。
 */
public class LeetCode_2116_Check_if_a_Parentheses_String_Can_Be_Valid {

    public static void main(String[] args) {
        LeetCode_2116_Check_if_a_Parentheses_String_Can_Be_Valid client = new LeetCode_2116_Check_if_a_Parentheses_String_Can_Be_Valid();
        System.out.println(client.canBeValid(")(", "00"));
    }

    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) return false;
        int need = 0, res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            // 先将可替换位置的括号替换成右括号
            if (locked.charAt(i) == '0') {
                chars[i] = ')';
                need++;
            }

            if (chars[i] == '(') {
                res++;
            } else {
                res--;
            }
            // 右括号有点多了
            if (res < 0) {
                // 如果没有能调整的左括号，不符合题意
                if (need == 0) return false;
                need--;
                // 前面多减了一次，左括号+2
                res += 2;
            }
        }
        return res == 0;
    }
}
