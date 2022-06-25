package com.leetcode.training.binarytree;

import com.leetcode.training.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrderPrint {


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        res.add(root.val);
        System.out.println(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }
}
