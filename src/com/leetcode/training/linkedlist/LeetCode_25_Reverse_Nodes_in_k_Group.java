package com.leetcode.training.linkedlist;

import com.leetcode.training.ListNode;

import java.util.List;

/**
 * @author chenhaowei
 * @date 2019.05.11
 */
public class LeetCode_25_Reverse_Nodes_in_k_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode tail = dummyHead;
        ListNode temp = null;
        while (true) {
            int count = 0;

            while (count <  k && tail != null) {
                count++;
                tail = tail.next;
            }
            if (tail == null) {
                break;
            }
            // 下一个partition的头结点
            head = tail.next;
            while (pre.next != tail) {
                temp = pre.next;
                pre.next = temp.next;
                temp.next = tail.next;
                tail.next = temp;
            }
            tail = head;
            pre = head;
        }

        return dummyHead.next;
    }
}

/**
 * 思路：
 * 1. 从head节点遍历k个节点，记录第k+1个节点，（若不足k个节点， break） 将前k个节点进行反转， 连接剩余的节点
 * 2. 继续执行第一步
 */
