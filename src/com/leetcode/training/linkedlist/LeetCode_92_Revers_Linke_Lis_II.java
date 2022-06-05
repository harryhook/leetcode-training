package com.leetcode.training.linkedlist;

import com.leetcode.training.ListNode;

public class LeetCode_92_Revers_Linke_Lis_II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode tail = pre.next;
        ListNode temp;
        for (int i = 0; i < n - m; i++) {
            temp = pre.next;
            pre.next = tail.next;
            tail.next = tail.next.next;
            pre.next.next = temp;
        }
        return dummyHead.next;
    }
}
