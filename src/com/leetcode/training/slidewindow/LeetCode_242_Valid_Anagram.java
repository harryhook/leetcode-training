package com.leetcode.training.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_242_Valid_Anagram {

    public static void main(String[] args) {
        LeetCode_242_Valid_Anagram client = new LeetCode_242_Valid_Anagram();
        System.out.println(client.isAnagram( "anagram",  "nagaram"));
    }
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) return false;

        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        int left = 0, right = 0, cnt = 0;
        // 统计t中字符出现的次数
        for (char c : t.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            char curr = s.charAt(right);
            right++;
            if (needMap.get(curr) == null)  return false;
            else {
                // 更新window
                windowMap.put(curr, windowMap.getOrDefault(curr, 0) + 1);
                if (needMap.get(curr).equals(windowMap.get(curr))) {
                    cnt++;
                }
            }
        }

        return  cnt == needMap.size();
    }
}
