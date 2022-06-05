package com.leetcode.training.linkedlist;

import com.leetcode.training.ListNode;
import com.leetcode.training.TreeNode;

/**
 * @author chenhaowei
 * @date 2019.07.06
 */
public class LeetCode_109_linked_list_convert_bst {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            temp = slow;
            slow = slow.next;

        }
        if (temp != null) {
            temp.next = null;
        } else {
            head = null;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}


