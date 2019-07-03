package com.leetcode.training;

/**
 * @author chenhaowei
 * @date 2019.07.03
 */
public class LeetCode_86_Partition_List {

    public ListNode partition(ListNode head, int x) {
        ListNode smallerNode = new ListNode(0);
        ListNode biggerode = new ListNode(0);
        ListNode smallerHead = smallerNode;
        ListNode biggerHead = biggerode;
        while (head != null) {
            if (head.val < x) {
                smallerNode.next = head;
                smallerNode = smallerNode.next;
            } else {
                biggerode.next = head;
                biggerode = biggerode.next;
            }
            head = head.next;
        }
        smallerNode.next = biggerHead.next;
        biggerode.next = null;
        return smallerHead.next;
    }
}
