package com.leetcode.training.binarytree;

import com.leetcode.training.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode_103_Binary_Tree_Zigzag_Level_Order_Traversa {

    public static void main(String[] args) {
        LeetCode_103_Binary_Tree_Zigzag_Level_Order_Traversa client = new LeetCode_103_Binary_Tree_Zigzag_Level_Order_Traversa();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = client.zigzagLevelOrder2(root);
        for (List<Integer> list : result) {
            System.out.println(list);
        }

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        // 双栈实现，s1用于存放当前层的节点，s2用于存放下一层的节点
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode node = s1.pop();
                list.add(node.val);
                if (node.left != null) s2.push(node.left);
                if (node.right != null) s2.push(node.right);
            }
            if (!list.isEmpty()) res.add(list);
            list = new ArrayList<>();
            while (!s2.isEmpty()) {
                TreeNode node = s2.pop();
                list.add(node.val);
                if (node.right != null) s1.push(node.right);
                if (node.left != null) s1.push(node.left);
            }
            if (!list.isEmpty()) res.add(list);
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        // 递归层次遍历， 记录层数
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, res, 0);

        return res;
    }

    private void traverse(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (res.size() == level) {
            res.add(new LinkedList<>());
        }
        List<Integer> temp = res.get(level);
        // 偶数层层从左向右记录
        if(level % 2 == 0) {
            temp.add(root.val);
        } else {
            // 奇数层从右向左记录
            temp.add(0, root.val);
        }
        traverse(root.left, res, level + 1);
        traverse(root.right, res, level + 1);




    }
}
