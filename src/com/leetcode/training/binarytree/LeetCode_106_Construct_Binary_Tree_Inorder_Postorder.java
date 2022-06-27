package com.leetcode.training.binarytree;

import com.leetcode.training.TreeNode;

public class LeetCode_106_Construct_Binary_Tree_Inorder_Postorder {

    public static void main(String[] args) {
        LeetCode_106_Construct_Binary_Tree_Inorder_Postorder client = new LeetCode_106_Construct_Binary_Tree_Inorder_Postorder();
        TreeNodePrint treeNodePrint = new TreeNodePrint();
        treeNodePrint.preorderTraversal(client.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(inorder.length == 0) return null;

        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        // 找到中序遍历的root的节点
        int index = -1;
        for(int i=inStart; i<=inEnd; i++) {
            if(root.val == inorder[i]) {
                index = i;
                break;
            }
        }
        // 后序遍历的左子树长度
        int leftSize = index - inStart;
        root.left = helper(inorder, inStart, index-1, postorder, postStart , postStart+leftSize-1);
        root.right = helper(inorder, index+1, inEnd,  postorder, postStart+leftSize, postEnd-1);
        return root;
    }

}
