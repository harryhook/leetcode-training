package com.leetcode.training;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_76_Minimum_Window_Substring {

    public static void main(String[] args) {
        LeetCode_76_Minimum_Window_Substring client = new LeetCode_76_Minimum_Window_Substring();

        char c = 0;
        System.out.println(--c);
        System.out.println(client.minWindow("ADBANC", "ABC"));
        ;
    }


    public String minWindow(String s, String t) {

        if (s == null || t == null || s.isEmpty() || t.isEmpty()) return "";

        Map<Character, Integer> map = new HashMap<>();

        int left = 0, cnt = 0, minLeft = 0, minLen = Integer.MAX_VALUE;
        String res = "";
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            if (map.get(curr) != null) {
                if (map.get(curr) > 0) {
                    cnt++;
                }
                map.put(curr, map.get(curr) - 1);

            }

            while (cnt == t.length()) {
                if (minLen > right - left + 1) {
                    minLeft = left;
                    minLen = right - left + 1;

                    res = s.substring(left, minLeft + minLen);
                }

                char leftChar = s.charAt(left);
                if (map.get(leftChar) != null) {
                    if (map.get(leftChar) >= 0) {
                        cnt--;
                    }
                    map.put(leftChar, map.get(leftChar) + 1);
                }
                left++;
            }
        }

        return res;
    }

    public String minWindow2(String s, String t) {

        if (s == null || t == null || s.isEmpty() || t.isEmpty()) return "";

       int[] maps = new int[128];

        int left = 0, cnt = 0, minLeft = 0, minLen = Integer.MAX_VALUE;
        String res = "";
        for (char c : t.toCharArray()) {
            maps[c]++;
        }

        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            if (--maps[curr] >= 0) {
                cnt++;
            }

            while (cnt == t.length()) {
                if (minLen > right - left + 1) {
                    minLeft = left;
                    minLen = right - left + 1;

                    res = s.substring(left, minLeft + minLen);
                }

                char leftChar = s.charAt(left);
                if (++maps[leftChar] > 0) {
                        cnt--;
                }
                left++;
            }
        }

        return res;
    }

}
