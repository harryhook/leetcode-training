package com.leetcode.training;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author chenhaowei
 * @date 2019.06.23
 */
public class LeetCode_234_Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack  = new Stack<>();
        ListNode temp = head;
        while(temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        while(head != null) {
            if(head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }

        return true;
    }
}
