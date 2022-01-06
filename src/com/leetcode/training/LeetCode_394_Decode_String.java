package com.leetcode.training;

import java.util.Stack;

/**
 * Example 1:
 * <p>
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 * <p>
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 * <p>
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Constraints:
 * <p>
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 */

public class LeetCode_394_Decode_String {


    public static void main(String[] args) {
        LeetCode_394_Decode_String client = new LeetCode_394_Decode_String();

        System.out.println(client.decodeString("2[abc]3[cd]ef"));
    }

    public String decodeString(String s) {

        //  stack存储 字符 和数字

        // 遇到[] 开始处理

        Stack<Integer> nums = new Stack<>();
        Stack<String> chars = new Stack<>();
        String res = "";
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                // 数字进行存储
                cnt = cnt * 10 + s.charAt(i) - '0';
            } else if (s.charAt(i) == '[') {
                nums.push(cnt);
                chars.push(res);
                cnt = 0;
                res = "";
            } else if (s.charAt(i) == ']') {
                int k = nums.pop();
                String currStr = chars.pop();
                for (int j = 0; j < k; j++) {
                    currStr += res;
                }
                res = currStr;
            } else {
                res += s.charAt(i);
            }
        }
        return res;
    }
}
