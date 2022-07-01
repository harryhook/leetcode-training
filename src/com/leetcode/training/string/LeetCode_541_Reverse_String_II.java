package com.leetcode.training.string;

public class LeetCode_541_Reverse_String_II {

    public static void main(String[] args) {
        LeetCode_541_Reverse_String_II client = new LeetCode_541_Reverse_String_II();
        String s = "abcdefg";
        System.out.println(client.reverseStr(s, 8));

    }
        public String reverseStr(String s, int k) {
            char[] ch = s.toCharArray();
            if(s.length() < k) {
                reverse(ch, 0, s.length() - 1);
                return new String(ch);
            }
            int start = 0;
            while( start < s.length()) {

                reverse(ch, start, start + k-1);
                start +=  2 * k;
            }
            return new String(ch);
        }
        private void reverse(char[] chars, int start, int end) {
            if(end >= chars.length) end = chars.length-1;
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
    }
