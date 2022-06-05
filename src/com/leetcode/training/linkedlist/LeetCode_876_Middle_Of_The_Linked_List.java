package com.leetcode.training.linkedlist;

import com.leetcode.training.ListNode;

/**
 * @author chenhaowei
 * @date 2019.05.19
 */
public class LeetCode_876_Middle_Of_The_Linked_List {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }
}
