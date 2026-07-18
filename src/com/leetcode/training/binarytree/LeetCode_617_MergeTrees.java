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
}
