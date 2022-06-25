package com.leetcode.training.binarytree;

import com.leetcode.training.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeNodePrint {


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        res.add(root.val);
        System.out.print(root.val + " ");
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        System.out.print(root.val + " ");
        res.addAll(inorderTraversal(root.right));
        return res;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        System.out.print(root.val + " ");
        return res;
    }
}
