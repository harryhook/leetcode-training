package com.leetcode.training;

import java.util.List;

/**
 * @author chenhaowei
 */
public class LeetCode_99_RecoverBinarySearchTree {

    TreeNode pre;
    TreeNode first;
    TreeNode second;

    public void recoverTree(TreeNode root) {

        // 中序遍历， 分别找到两个不符的值， 利用三指针， pre记录前一个节点， fisrt记录第一个错位的结点，second为第二个错位的结点
        inOrder(root);
        if(first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
//        // 中序遍历找到全部节点， 排序后对树重新赋值
//        List<TreeNode> inOrderList = new ArrayList<>();
//        inOrderTravel(inOrderList, root);
//        int[] values = new int[inOrderList.size()];
//        for(int i=0; i<inOrderList.size();i++) {
//            values[i] = inOrderList.get(i).val;
//        }
//        Arrays.sort(values);
//        for(int i=0; i< values.length; i++) {
//            inOrderList.get(i).val = values[i];
//        }

    }
    void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (pre != null) {
            if (pre.val > root.val) {
                if (first == null) first = pre;
                second = root;
            }
        }
        pre = root;
        inOrder(root.right);
    }

    void inOrderTravel(List<TreeNode> inOrderList, TreeNode root) {
        if (root == null) return;
        inOrderTravel(inOrderList, root.left);
        inOrderList.add(root);
        inOrderTravel(inOrderList, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);

        root.left = left;
        left.right = right;

        LeetCode_99_RecoverBinarySearchTree client = new LeetCode_99_RecoverBinarySearchTree();
        client.recoverTree(root);
    }

}
