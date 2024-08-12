package com.leetcode.training.binarytree;

public class Leetcode_676_MagicDictionary {

    public static void main(String[] args) {
        Leetcode_676_MagicDictionary magicDictionary = new Leetcode_676_MagicDictionary();
        String[] dictionary = {"hello", "leetcode"};
        magicDictionary.buildDict(dictionary);
        
        System.out.println(magicDictionary.search("hello")); // 应该返回 false
        System.out.println(magicDictionary.search("hhllo")); // 应该返回 true
        System.out.println(magicDictionary.search("hell")); // 应该返回 false
        System.out.println(magicDictionary.search("leetcoded")); // 应该返回 false
    }

    String[] dict;
    public Leetcode_676_MagicDictionary() {

    }
    
    public void buildDict(String[] dictionary) {
        // 存储数据
        this.dict = dictionary;
    }
    
    public boolean search(String searchWord) {
        // 查询字符串替换一个字符后是否能够跟字典中的数据匹配
        for (String word : dict) {
            if (word.length() == searchWord.length()) {
                int diff = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) != searchWord.charAt(i)) {
                        diff++;
                    }
                    if (diff > 1) {
                        break;
                    }
                }
                if (diff == 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
