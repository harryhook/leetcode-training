package com.leetcode.training;

import java.util.Stack;

public class Flatteren {
    public Node flattern(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        while (p != null) {
            if (p.child == null) {
                p = p.next;
                continue;
            }
            Node temp = p.child;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = p.next;
            if (p.next != null) {
                p.next.prev = temp;
            }

            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int _val, Node _prev, Node _next, Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}
