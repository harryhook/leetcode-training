package com.leetcode.training;

public class LeetCode_394_Decode_String {

    public static void main(String[] args) {
        LeetCode_394_Decode_String client = new LeetCode_394_Decode_String();

        client.decodeString("3[a]2[bc]");
    }
    public String decodeString(String s) {

        StringBuilder res = new StringBuilder();

        int count = 0;
        for(int i=s.length()-1; i>=0; i--) {

            if(s.charAt(i) != '[' || s.charAt(i) != ']') {
                res.append(s.charAt(i));
            }
            if(s.charAt(i) != ']') {
                count++;
            }
            if(s.charAt(i) == '[') {

            }
        }
        return null;
    }
}
