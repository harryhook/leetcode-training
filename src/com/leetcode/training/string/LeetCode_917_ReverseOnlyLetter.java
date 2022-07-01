package com.leetcode.training.string;

public class LeetCode_917_ReverseOnlyLetter {

    public static void main(String[] args) {
        LeetCode_917_ReverseOnlyLetter client = new LeetCode_917_ReverseOnlyLetter();
        String s = "7_28]";
        System.out.println(client.reverseOnlyLetters(s));
    }

    public String reverseOnlyLetters(String s) {

        char[] ch = s.toCharArray();

        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (isLeter(ch[i]) && isLeter(ch[j])) {
                swap(ch, i, j);
                i++;
                j--;
            } else {
                if (!isLeter(ch[i])) {
                    i++;
                }
                if (!isLeter(ch[j])) {
                    j--;
                }
            }

        }
        return new String(ch);
    }

    boolean isLeter(char c) {
        if (c >= 'a' && c <= 'z')
            return true;
        if (c >= 'A' && c <= 'Z')
            return true;
        return false;
    }

    private void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
