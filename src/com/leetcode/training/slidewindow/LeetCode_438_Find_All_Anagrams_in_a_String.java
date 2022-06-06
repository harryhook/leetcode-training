package com.leetcode.training.slidewindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_438_Find_All_Anagrams_in_a_String {

    public static void main(String[] args) {

        LeetCode_438_Find_All_Anagrams_in_a_String client = new LeetCode_438_Find_All_Anagrams_in_a_String();
        System.out.println(client.findAnagrams("abab", "ab"));

    }

    public List<Integer> findAnagrams(String s, String t) {


        if (s == null || t == null || s.isEmpty() || t.isEmpty()) return new ArrayList<>();

        Map<Character, Integer> needMmap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        int left = 0, right = 0, cnt = 0;
        List<Integer> res = new ArrayList<>();
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
            while (right - left >= t.length()) {

                if (cnt == needMmap.size()) res.add(left);

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

        return res;
    }


}
