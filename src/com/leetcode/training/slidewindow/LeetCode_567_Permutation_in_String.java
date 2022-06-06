package com.leetcode.training.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_567_Permutation_in_String {

    public static void main(String[] args) {

        LeetCode_567_Permutation_in_String client = new LeetCode_567_Permutation_in_String();
        System.out.println(client.checkInclusion("abcdxabcde", "abcdeabcdx"));

    }

    public boolean checkInclusion(String s, String t) {

        if (s == null || t == null || s.isEmpty() || t.isEmpty()) return false;

        Map<Character, Integer> needMmap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        int left = 0, right = 0, cnt = 0;
        // 统计t中字符出现的次数
        for (char c : s.toCharArray()) {
            needMmap.put(c, needMmap.getOrDefault(c, 0) + 1);
        }

        while (right < t.length()) {
            char curr = t.charAt(right);
            right++;
            if (needMmap.get(curr) != null) {
                // 更新window
                windowMap.put(curr, windowMap.getOrDefault(curr, 0) + 1);
                if (needMmap.get(curr).equals(windowMap.get(curr))) {
                    cnt++;
                }
            }
            // 左侧窗口是否需要收缩
            while (right - left >= s.length()) {

                if (cnt == needMmap.size()) return true;

                char leftChar = t.charAt(left);

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

        return false;
    }


}
