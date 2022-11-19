package com.leetcode.training.string;

public class LeetCode_557_Reverse_Words_in_a_String_III {

    public static void main(String[] args) {
        LeetCode_557_Reverse_Words_in_a_String_III client = new LeetCode_557_Reverse_Words_in_a_String_III();

        System.out.println(client.reverseWords("  hello world  "));
    }

    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        // 先整体反转，  再单个反转
        char[] ch = s.toCharArray();
        int n = ch.length - 1;

        reverse(ch, 0, n);

        reverseAwards(ch, n);

        return cleanSpaces(ch, n);

    }



    private void reverseAwards(char[] ch, int n) {
        int i=0, j = 0;

        while( i<= n ) {
            // skip spaces,
            while (i < j || i <= n && ch[i] == ' ') {
                i++;
            }
           // skip non spaces
            while (j < i || j <= n && ch[j] != ' ') {
                j++;
            }
            // reverse signal word
            reverse(ch, i, j-1);
        }
    }

    private String cleanSpaces(char[] ch, int n) {
        int i = 0, j = 0;
        while(j< n) {
            // skip spaces
            while (j <= n && ch[j] == ' ') {
                j++;
            }
            // keep non spaces
            while(j <= n && ch[j] != ' ') {
                ch[i++] = ch[j++];
            }
            // skip spaces
            while (j<=n && ch[j] == ' ') {
                j++;
            }
            // keep only one space
            if(j<=n) {
                ch[i++] = ' ';
            }
        }
        return new String(ch).substring(0, i);
    }

    private void reverse(char[] ch, int i, int j) {
        while (i < j) {
            char tmp = ch[j];
            ch[j] = ch[i];
            ch[i] = tmp;
            i++;
            j--;
        }
    }
}

