package com.leetcode.training.linkedlist;

import com.leetcode.training.ListNode;

/**
 * 1.利用虚拟头结点使得所有结点按同样的逻辑处理；
 * 2.通过 pre 指针遍历链表， 找到第一个比之前结点小的结点， 记录 pre 信息；
 * 3.进行插入操作, pre节点回到起始位置重新执行
 */
public class leetcode_147_insertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            // find insert node
            while (pre.next != null && pre.next.val < cur.val) {
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

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(1);
        node2.next = node3;

        leetcode_147_insertionSortList client = new leetcode_147_insertionSortList();

        client.insertionSortList(head);





    }
}
