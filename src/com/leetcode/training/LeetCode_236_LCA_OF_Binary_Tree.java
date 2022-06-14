package com.leetcode.training;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_236_LCA_OF_Binary_Tree {

    public static void main(String[] args) {
        LeetCode_236_LCA_OF_Binary_Tree client = new LeetCode_236_LCA_OF_Binary_Tree();
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode left1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(4);
        TreeNode left2 = new TreeNode(5);

        root.left = left1;
        root.right = right1;

        right1.right = right2;
        left1.left = left2;


        System.out.println(client.lowestCommonAncestor(root, right2, right1).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null ) return null;

        if(root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;

        return left != null ? left : right;


    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

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
