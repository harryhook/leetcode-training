package com.leetcode.training.string;

public class LeetCode_557_Reverse_Words_in_a_String_III {

    public static void main(String[] args) {
        LeetCode_557_Reverse_Words_in_a_String_III client = new LeetCode_557_Reverse_Words_in_a_String_III();

        System.out.println(client.reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {

        char[] chars = s.toCharArray();
        int curStart = 0;
        for (int curEnd = 0; curEnd < s.length(); curEnd++) {
            if (chars[curEnd] == ' ') {
                reverse(chars, curStart, curEnd - 1);
                curStart = curEnd + 1;
            }
        }
        reverse(chars, curStart, s.length() - 1);
        return new String(chars);

    }

    private void reverse(char[] chars, int start, int end) {

        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}

