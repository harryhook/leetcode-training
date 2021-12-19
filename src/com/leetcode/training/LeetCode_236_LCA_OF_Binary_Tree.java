package com.leetcode.training;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_236_LCA_OF_Binary_Tree {

    public static void main(String[] args) {
        LeetCode_236_LCA_OF_Binary_Tree client = new LeetCode_236_LCA_OF_Binary_Tree();

        client.lowestCommonAncestor(null, null, null);
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);

        if (left != null && right != null) return root;

        return left != null ? left : right;


    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<Integer> rootPath = new ArrayList<>();
        List<Integer> pPath = new ArrayList<>();
        List<Integer> qpath = new ArrayList<>();


        findPath(root, rootPath);
        findPath(root, pPath);
        findPath(root, qpath);

        return null;

    }

    private void findPath(TreeNode root, List<Integer> path) {

        if (root == null) return;
        path.add(root.val);

        findPath(root.left, path);
        findPath(root.right, path);

    }
}
