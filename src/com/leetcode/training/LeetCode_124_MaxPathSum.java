package com.leetcode.training;

public class LeetCode_124_MaxPathSum {

    Integer res = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        LeetCode_124_MaxPathSum client = new LeetCode_124_MaxPathSum();

        System.out.println(client.maxPathSum(root));



    }
    public int maxPathSum(TreeNode root) {

        helper(root);

        return res;
    }
    public int helper(TreeNode node) {
        if(node == null) return 0;

        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);

        res = Math.max(res, left + right + node.val);

        return Math.max(left, right) + node.val;
    }


}
