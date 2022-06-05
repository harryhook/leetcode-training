package com.leetcode.training.linkedlist;

import com.leetcode.training.ListNode;

/**
 * @author chenhaowei
 * @date 2019.05.19
 */
public class LeetCode_203_Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        if (head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummyHead.next;
    }
}
