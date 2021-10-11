package com.leetcode.training;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_76_Minimum_Window_Substring {

    public static void main(String[] args) {
        LeetCode_76_Minimum_Window_Substring client = new LeetCode_76_Minimum_Window_Substring();

        System.out.println(client.minWindow("ADBANC", "ABC"));;
    }


    public String minWindow(String s, String t) {

        if (s == null || t == null || s.isEmpty() || t.isEmpty()) return "";

        Map<Character, Integer> map = new HashMap<>();

        int left = 0, cnt = 0, minLen = Integer.MAX_VALUE;

        String res = "";
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (map.get(curr) != null && map.get(curr) >= 0) {
                cnt++;
                map.put(curr, map.get(curr) - 1);
            }

            while (cnt == t.length()) {
                if (minLen > i - left + 1) {
                    minLen = i - left + 1;
                    res = s.substring(left, minLen);
                }

                if (map.get(curr) != null && map.get(curr) > 0) {
                    map.put(curr, map.get(s.charAt(curr)) + 1);
                    cnt--;
                }
                left++;
            }
        }

        return res;
    }

}
