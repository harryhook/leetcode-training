package com.leetcode.training.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_392_IsSubsequence {
    public boolean isSubsequence1(String s, String t) {

        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return s.length() == i;

    }

    public boolean isSubsequence(String s, String t) {

        // 另一种做法，统计t中出现的频次
        List<Integer>[] index = new ArrayList[256];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (index[c] == null) {
                index[c] = new ArrayList<>();
            }
            index[c].add(i);
        }
        // t的下标
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 数组中不存在当前的字符
            if (index[c] == null) return false;
            // 利用二分查找， 第一个大于等于的节点
            int pos = findLeftBound(index[c], j);
            // 二分查找中没有找到字符c
            if (pos == index[c].size()) return false;
            // j++ 到下一个元素
            j = index[c].get(pos) + 1;

        }
        return true;
    }

    // 寻找第一个大于等于的那个节点
    private int findLeftBound(List<Integer> nums, int currIndex) {
        int low = -1, high = nums.size();

        while (low != high - 1) {
            int mid = low + (high - low) / 2;
            if (currIndex <= nums.get(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        LeetCode_392_IsSubsequence client = new LeetCode_392_IsSubsequence();
        System.out.println(client.isSubsequence("abc", "ahbgdc"));
    }
}
