package com.leetcode.training.linkedlist;

import com.leetcode.training.ListNode;

/**
 * @author chenhaowei
 * @date 2019.05.19
 */
public class LeetCode237_delete_node_in_a_linked_list {
    public void deleteNode(ListNode node) {
        ListNode pre = node;
        while (node.next != null) {
            pre = node;
            node.val = node.next.val;
            node = node.next;
        }
        pre.next = null;
    }
}
