package com.leetcode.training.slidewindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_187_RepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        // seen 看到的字符串， repeat 重复的字符串
        Map<String, Integer> seen = new HashMap<>();
        List<String> repeat = new ArrayList<>();

        for (int i = 0; i + 10 <= s.length(); i++) {
            String cur = s.substring(i, i + 10);
            int cnt = seen.getOrDefault(cur, 0);
            if (cnt == 1) {
                repeat.add(cur);
            }
            seen.put(cur, cnt + 1);
        }
        return repeat;
    }

    public static void main(String[] args) {
        LeetCode_187_RepeatedDnaSequences client = new LeetCode_187_RepeatedDnaSequences();
        List<String> res = client.findRepeatedDnaSequences("GATGGATACAAACCCCCCCCCCCC");
        res.forEach(System.out::println);
    }
}
