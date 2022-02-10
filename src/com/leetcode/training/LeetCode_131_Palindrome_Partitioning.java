package com.leetcode.training;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhaowei
 */
public class LeetCode_131_Palindrome_Partitioning {


    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        bt(res, curr, s);
        return res;
    }

    private void bt(List<List<String>> res, List<String> curr, String s) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(curr));
        }

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i + 1))) {
                curr.add(s.substring(0, i + 1));
                bt(res, curr, s.substring(i + 1));
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {

        if (s.isEmpty()) return false;

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    public static void main(String[] args) {
        LeetCode_131_Palindrome_Partitioning client = new LeetCode_131_Palindrome_Partitioning();

        List<List<String>> res =  client.partition("aab");

    }

}
