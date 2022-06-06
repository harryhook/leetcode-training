package com.leetcode.training.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_76_Minimum_Window_Substring {

    public static void main(String[] args) {
        LeetCode_76_Minimum_Window_Substring client = new LeetCode_76_Minimum_Window_Substring();

        System.out.println(client.minWindow("EBBANCF", "ABC"));

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
            }
        }

        return res;
    }

    public String minWindow2(String s, String t) {

        if (s == null || t == null || s.isEmpty() || t.isEmpty()) return "";

        Map<Character, Integer> needMmap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        int left = 0, right = 0, cnt = 0, minLeft = 0, minLen = Integer.MAX_VALUE;
        // 统计t中字符出现的次数
        for (char c : t.toCharArray()) {
            needMmap.put(c, needMmap.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            char curr = s.charAt(right);
            right++;
            if (needMmap.get(curr) != null) {
                // 更新window
                windowMap.put(curr, windowMap.getOrDefault(curr, 0) + 1);
                if (needMmap.get(curr).equals(windowMap.get(curr))) {
                    cnt++;
                }
            }
            // 左侧窗口是否需要收缩
            while (cnt == t.length()) {
                if (minLen > right - left) {
                    minLeft = left;
                    minLen = right - left;
                }
                char leftChar = s.charAt(left);
                left++;
                // 进行窗口的下一次调整
                if (needMmap.get(leftChar) != null) {
                    if (needMmap.get(leftChar).equals(windowMap.get(leftChar))) {
                        cnt--;
                    }
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }


}
