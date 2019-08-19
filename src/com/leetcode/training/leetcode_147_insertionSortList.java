package com.leetcode.training;

public class leetcode_147_insertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null) {
            next = cur.next;
            // find insert node
            while(pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            // insert pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = dummyHead;
            cur = next;
        }
        return dummyHead.next;
    }
}
