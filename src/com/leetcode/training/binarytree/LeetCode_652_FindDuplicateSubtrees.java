package com.leetcode.training.binarytree;

import com.leetcode.training.TreeNode;

import java.util.*;

public class LeetCode_652_FindDuplicateSubtrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);

        root.left = left1;
        root.right = right1;

        TreeNode left21 = new TreeNode(4);
        TreeNode left22 = new TreeNode(2);
        TreeNode right22 = new TreeNode(4);
        left1.left = left21;
        right1.left = left22;
        right1.right = right22;

        TreeNode right32 = new TreeNode(4);
        left22.left = right32;

        LeetCode_652_FindDuplicateSubtrees client = new LeetCode_652_FindDuplicateSubtrees();
        List<TreeNode> roots =  client.findDuplicateSubtrees(root);
        TreeNodePrint treeNodePrint = new TreeNodePrint();

        for (TreeNode treeNode : roots) {
            treeNodePrint.inorderTraversal(treeNode);
        }

    }
    List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Set<TreeNode> res = new HashSet<>();
        Map<String, Integer> mem = new HashMap<>();

        postorder(root, mem, res);
        return res.size() == 0 ? new ArrayList<>() : new ArrayList<>(res);
    }

    private String postorder(TreeNode root, Map<String, Integer> memo, Set<TreeNode> res) {
        if (root == null) {
            return "#";
        }
        String left = postorder(root.left, memo, res);
        String right = postorder(root.right, memo, res);
        String subTree = left + "," + right + "，" + root.val;
        // 出现重复的添加进去
        int freq = memo.getOrDefault(subTree, 0);
        // 多次重复也只会被加入结果集一次
        if (freq == 1) {
            res.add(root);
        }
        // 给子树对应的出现次数加一
        memo.put(subTree, freq + 1);
        return subTree;

    }

}
