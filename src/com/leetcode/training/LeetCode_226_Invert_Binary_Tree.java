package com.leetcode.training;

import java.util.Stack;

public class LeetCode_226_Invert_Binary_Tree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            if(node != null) {
                TreeNode tmp = node.right;
                node.right = node.left;
                node.left = tmp;
                stack.add(node.left);
                stack.add(node.right);
            }

        }

        return root;
    }

    public static void main(String[] args) {

        LeetCode_226_Invert_Binary_Tree client = new LeetCode_226_Invert_Binary_Tree();

        TreeNode root = new TreeNode(1);

        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);

        root.left = left1;
        root.right = right1;

        TreeNode left2 = new TreeNode(4);
        right1.left = left2;


        client.inorder(root);
        System.out.println("=======");
        client.invertTree1(root);
        client.inorder(root);


    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        inorder(root.left);
        inorder(root.right);


    }
}
