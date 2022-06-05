package com.leetcode.training.binarytree;


import com.leetcode.training.TreeNode;

/**
 * 后继节点
 */
public class LeetCode_285_InorderSuccessor {
    //
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        TreeNode t = null;
        while (root != null) {
            if (root.val > p.val) {
                t = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return t;
    }

    public TreeNode successor(TreeNode x) {
        TreeNode successor;
        if (x.right != null) {
            successor = x;
            x = x.right;
            while (x.left != null) {
                x = x.left;
                successor = x.left;
            }
            return successor;
        } else {

            TreeNode y = x.getParent();
            // 当前节点没有右子树， 分两种情况考虑
            // 当前节点只有左子树， 返回当前节点的父节点
            // 当前节点是一颗右子树，需要找到x最近的父节点且父节点要具有左子树
            while (y != null && x == y.right) {
                x = y;
                y = y.parent;
            }

            return y;
        }

    }
}
