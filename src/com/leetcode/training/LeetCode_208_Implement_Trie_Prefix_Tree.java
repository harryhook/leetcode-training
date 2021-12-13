package com.leetcode.training;

public class LeetCode_208_Implement_Trie_Prefix_Tree {

    public static void main(String[] args) {
        LeetCode_208_Implement_Trie_Prefix_Tree client = new LeetCode_208_Implement_Trie_Prefix_Tree();

        Trie trie = new Trie();

        trie.insert("apple");
        boolean res1 = trie.search("apple");   // return True
        boolean res2 = trie.search("app");     // return False
        boolean res3 = trie.startsWith("app"); // return True
        trie.insert("app");
        boolean res4 = trie.search("app");     // return True

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }

}

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode ws = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (ws.child[c - 'a'] == null) {
                ws.child[c - 'a'] = new TrieNode();
            }
            ws = ws.child[c - 'a'];
        }

        ws.isWord = true;
    }

    public boolean search(String word) {
        TrieNode ws = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (ws.child[c - 'a'] == null) {
                return false;
            }
            ws = ws.child[c - 'a'];
        }

        return ws.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode ws = root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if (ws.child[c - 'a'] == null) {
                return false;
            }
            ws = ws.child[c - 'a'];
        }

        return true;
    }
}

class TrieNode {
    boolean isWord;
    TrieNode[] child = new TrieNode[26];

    public TrieNode() {
    }
}