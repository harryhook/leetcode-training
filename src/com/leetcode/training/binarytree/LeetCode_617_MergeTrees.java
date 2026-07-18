package com.leetcode.training.binarytree;

import com.leetcode.training.TreeNode;

public class LeetCode_617_MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;

        int val = (root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val);
        TreeNode node = new TreeNode(val);
        node.left = mergeTrees((root1 == null ? null : root1.left), (root2 == null ? null : root2.left));
        node.right = mergeTrees((root1 == null ? null : root1.right), (root2 == null ? null : root2.right));
        return node;

    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);

        TreeNode merged = new LeetCode_617_MergeTrees().mergeTrees(root1, root2);
        System.out.println(merged.val);
        System.out.println(merged.left.val);
        System.out.println(merged.right.val);
        System.out.println(merged.left.left.val);
        System.out.println(merged.right.right.val);
        System.out.println(merged.left.right.val);
    }
}
