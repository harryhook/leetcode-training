package com.leetcode.training;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_139_WordBreak {


    public static void main(String[] args) {
        LeetCode_139_WordBreak leetCode_139_wordBreak = new LeetCode_139_WordBreak();


        boolean result = leetCode_139_wordBreak.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
        System.out.println(result);
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        Set<String> visited = new HashSet<>();

        return helper(s, visited, set);
    }

    public boolean helper(String s, Set<String> visited, Set<String> wordSet) {

        if (s.length() == 0) return true;

        if (visited.contains(s)) {
            return false;
        }


        for (int i = 1; i <= s.length(); i++) {
            String word = s.substring(0, i);
            visited.add(word);
            if (wordSet.contains(word)) {
                if (helper(s.substring(i), visited, wordSet)) {
                    return true;
                }
            }
        }
        return false;
    }
}
