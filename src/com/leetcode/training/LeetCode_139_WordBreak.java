package com.leetcode.training;

import java.util.*;

public class LeetCode_139_WordBreak {


    public static void main(String[] args) {
        LeetCode_139_WordBreak leetCode_139_wordBreak = new LeetCode_139_WordBreak();

        boolean result = leetCode_139_wordBreak.wordBreak("catsandogcat",
                Arrays.asList("cats","dog","sand","and","cat","an"));
        System.out.println(result);
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        Map<String, Boolean> visited = new HashMap<>();

        return helper(s, visited, set);
    }

    public boolean wordBreak1(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (i + word.length() <= s.length() && s.startsWith(word, i)) {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i]) break;
            }
        }

        return dp[0];
    }

    private boolean helper(String s, Map<String, Boolean> visited, Set<String> wordSet) {

        if (s.length() == 0) return true;

        if (visited.containsKey(s)) {
            return visited.get(s);
        }


        for (int i = 1; i <= s.length(); i++) {
            String word = s.substring(0, i);

            if (wordSet.contains(word) && helper(s.substring(i), visited, wordSet)) {
                visited.put(word, true);
                return true;
            }
        }
        visited.put(s, false);

        return false;
    }
}
