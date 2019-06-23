package com.leetcode.training;

/**
 * @author chenhaowei
 * @date 2019.06.23
 */
public class LeetCode_160_Intersection_Of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    public ListNode getIntersectionNodeB(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if (lenA - lenB > 0) {
            int diff = lenA - lenB;
            while (diff-- > 0) {
                headA = headA.next;
            }
        } else {
            int diff = lenB - lenA;
            while (diff-- > 0) {
                headB = headB.next;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

}
