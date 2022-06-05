package com.leetcode.training.slidewindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenhaowei
 * @date 2019.03.19
 */
public class LeetCode_3_LongestSubstring {

    public static void main(String[] args) {
        LeetCode_3_LongestSubstring client = new LeetCode_3_LongestSubstring();
        System.out.println(client.lengthOfLongestSubstring1("abcabcd"));
    }
    public int lengthOfLongestSubstring(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isUniqueStr(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    private boolean isUniqueStr(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    public int lengthOfLongestSubstring1(String s) {
        int right = 0, left = 0, res = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                res = Math.max(res, set.size());
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return res;
    }

    public int fun(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}
