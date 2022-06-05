package com.leetcode.training.linkedlist;

import com.leetcode.training.ListNode;

/**
 * @author chenhaowei
 * @date 2019.08.17
 */
public class LeetCode_725_SplitListToParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] parts = new ListNode[k];
        int len = 0;
        for (ListNode node = root; node != null; node = node.next) {
            len++;
        }
        // 每段分区的大小
        int n = len / k;
        // 第一个分区额外所需的大小
        int r = len % k;

        ListNode node = root, pre = null;

        for (int i = 0; node != null && i < k; i++, r--) {
            parts[i] = node;
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) {
                pre = node;
                node = node.next;
            }
            //断链
            pre.next = null;
        }
        return parts;
    }
}
