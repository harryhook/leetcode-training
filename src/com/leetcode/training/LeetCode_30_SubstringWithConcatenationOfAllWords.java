package com.leetcode.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_30_SubstringWithConcatenationOfAllWords {


    public static void main(String[] args) {

        LeetCode_30_SubstringWithConcatenationOfAllWords client = new LeetCode_30_SubstringWithConcatenationOfAllWords();

        System.out.println(client.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
        ;
    }

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        int totalWordsLength = 0;
        Map<String, Integer> wordCounts = new HashMap<>();
        int w = words[0].length();
        for (String word : words) {
            totalWordsLength += word.length();
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        if (s.length() < totalWordsLength) {
            return result;
        }
        Map<String, Integer> tempMap = new HashMap<>();
        for (int start = 0; start + totalWordsLength <= s.length(); start++) {
            int j = 0;
            tempMap.clear();
            tempMap = new HashMap<>(wordCounts);

            for (; j < totalWordsLength; j += w) {
                String temp = s.substring(start + j, start + j + w);

                if (tempMap.containsKey(temp)) {
                    tempMap.put(temp, tempMap.get(temp) - 1);

                    if (tempMap.get(temp) < 0) break;

                } else {
                    break;
                }

            }
            if (j == totalWordsLength) {
                result.add(start);
            }
        }


        return result;
    }
}
