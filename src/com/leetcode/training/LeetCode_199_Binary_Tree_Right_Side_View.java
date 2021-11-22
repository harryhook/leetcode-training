package com.leetcode.training;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_199_Binary_Tree_Right_Side_View {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);

        root.left = left1;
        root.right = right1;

        TreeNode left2 = new TreeNode(4);
        right1.left = left2;


        LeetCode_199_Binary_Tree_Right_Side_View leetCode_199_binary_tree_right_side_view = new LeetCode_199_Binary_Tree_Right_Side_View();

        System.out.println(leetCode_199_binary_tree_right_side_view.rightSideView(root));
    }



    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        rightView(root, res, 0);

        return res;
    }

    private void rightView(TreeNode root, List<Integer> res, int depth) {
        if (root == null) return;

        if (depth == res.size()) {
            res.add(root.val);
        }
        rightView(root.right, res, depth + 1);
        rightView(root.left, res, depth + 1);

    }
}