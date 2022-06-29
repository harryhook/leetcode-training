package com.leetcode.training.string;

public class LeetCode_541_Reverse_Words_in_a_String_II {

    public static void main(String[] args) {
        LeetCode_541_Reverse_Words_in_a_String_II client = new LeetCode_541_Reverse_Words_in_a_String_II();

        System.out.println(client.reverseStr("Let's take LeetCode contest", 2));
    }

    public String reverseStr(String s, int k) {
        if (s.length() < k) return s;
        char[] ch = s.toCharArray();
        int start = 0;
        while (start < s.length()) {

            reverse(ch, start, start + k - 1);
            start = start + 2 * k;
        }
        return new String(ch);
    }

    private void reverse(char[] chars, int start, int end) {
        if (end >= chars.length) end = chars.length - 1;
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}