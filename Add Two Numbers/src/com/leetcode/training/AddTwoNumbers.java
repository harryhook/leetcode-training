package com.leetcode.training;


/**
 * @author chenhaowei
 * @date 2019.03.19
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * @author chenhaowei
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode head1 = getListOne(new ListNode(1));
        ListNode head2 = getListTwo(new ListNode(2));
        handleAddTwoNumbers(head1, head2);
    }

    public static ListNode handleAddTwoNumbers(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = head1;
        ListNode q = head2;
        ListNode cur = dummyHead;

        int carry = 0, sum = 0;
        while (p != null || q != null) {
            int x = (p == null ? 0 : p.val);
            int y = (q == null ? 0 : q.val);
            sum = carry + x + y;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static ListNode getListOne(ListNode head1) {

        ListNode node1 = new ListNode(2);
        head1.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        return head1;
    }

    public static ListNode getListTwo(ListNode head2) {

        ListNode node1 = new ListNode(3);
        head2.next = node1;
        ListNode node2 = new ListNode(4);
        node1.next = node2;
        ListNode node3 = new ListNode(5);
        node2.next = node3;
        return head2;
    }
}
