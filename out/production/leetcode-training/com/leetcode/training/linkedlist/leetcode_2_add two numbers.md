# Add two numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)

Output: 7 -> 0 -> 8

Explanation: 342 + 465 = 807.


# 思路

注意边界情况， 当一个节点为null时要做非空判断， 为null时将当前节点的值设为0，
设置一个虚拟头节点， 一次遍历两个链表，并做进位处理， 循环结束后判断当前进位值是否大于1
， 大于1生成新的节点进行保存

```java
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

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

```