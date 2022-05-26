package com.leetcode.training;

/**
 * @author chenhaowei
 * @date 2020.08.03
 */
public class LeetCode_242_Valid_Anagram {

    public static void main(String[] args) {
        LeetCode_242_Valid_Anagram client = new LeetCode_242_Valid_Anagram();

        System.out.println( client.isAnagram("aa", "b"));


    }

    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
            if (alphabet[s.charAt(i) - 'a'] < 0) {
                return false;

            }
        }

        for (int i : alphabet) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }




}
