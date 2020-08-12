package com.leetcode.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author chenhaowei
 * @date 2020.08.03
 */
public class LeetCode_49_Group_Anagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate"};
        LeetCode_49_Group_Anagrams client = new LeetCode_49_Group_Anagrams();
        System.out.println(client.groupAnagrams(strs));

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> maps = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String keyStr = String.valueOf(chars);
            if (!maps.containsKey(keyStr)) {

                maps.put(keyStr, new ArrayList<>());
            }

            maps.get(keyStr).add(str);

        }

        return new ArrayList<>(maps.values());
    }
}
