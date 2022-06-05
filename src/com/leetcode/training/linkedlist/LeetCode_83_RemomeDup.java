package com.leetcode.training.linkedlist;

import com.leetcode.training.ListNode;

/**
 * @author chenhaowei
 * @date 2019.04.21
 */
public class LeetCode_83_RemomeDup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        deleteDuplicates(getList(head));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead, p = head;
        cur.next = head;

        while (p != null) {
            while (p != null && cur.val == p.val) {
                p = p.next;
            }
            if (p == null) {
                cur.next = null;
            } else {
                cur.next = p;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static ListNode getList(ListNode head) {
        ListNode n1 = new ListNode(1);
        head.next = n1;
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        ListNode n3 = new ListNode(2);
        n2.next = n3;
        ListNode n4 = new ListNode(3);
        n3.next = n4;
        ListNode n5 = new ListNode(3);
        n4.next = n5;

        return head;
    }

    public ListNode deleteDuplicate(ListNode head) {

        ListNode ref = head;
        while (ref.next != null) {
            if (ref.val == ref.next.val) {
                ref.next = ref.next.next;
            } else {
                ref = ref.next;
            }
        }
        return head;


    }
}
