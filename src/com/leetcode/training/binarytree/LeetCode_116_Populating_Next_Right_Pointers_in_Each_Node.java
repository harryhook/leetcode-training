package com.leetcode.training.binarytree;

import com.leetcode.training.Node;

public class LeetCode_116_Populating_Next_Right_Pointers_in_Each_Node {

    public static void main(String[] args) {
        LeetCode_116_Populating_Next_Right_Pointers_in_Each_Node client = new LeetCode_116_Populating_Next_Right_Pointers_in_Each_Node();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        client.connect2(root);
        System.out.println(root.left.left.val);
        System.out.println(root.left.left.next.val);
        System.out.println(root.left.right.next.val);
        System.out.println(root.right.left.next.val);


    }

    public Node connect(Node root) {

        if (root == null) return null;

        traverse(root.left, root.right);
        return root;
    }

    public Node connect2(Node root) {

        if (root == null) return null;

        Node pre = root;
        // 从左往有遍历， 左节点链接完毕， 右节点进行链接， 也就是cur.right.next -> cur.next.left
        while (pre.left != null) {
            Node cur = pre;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            pre = pre.left;
        }

        return root;
    }

    public void traverse(Node node1, Node node2) {

        if (node1 == null || node2 == null) return;

        node1.next = node2;

        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        traverse(node1.right, node2.left);

    }
}


