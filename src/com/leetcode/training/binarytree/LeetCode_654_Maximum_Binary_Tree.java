package com.leetcode.training.binarytree;

import com.leetcode.training.TreeNode;

/**
 * 给定一个数组， 找到最大元素， 最大元素左侧为左子树， 右侧元素为右子树
 *
 */
public class LeetCode_654_Maximum_Binary_Tree {

    public static void main(String[] args) {
        LeetCode_654_Maximum_Binary_Tree client = new LeetCode_654_Maximum_Binary_Tree();
        PreOrderPrint print = new PreOrderPrint();
        print.preorderTraversal(client.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5}));
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        // find max , build left and right

        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums,  int low , int high) {
        if(low > high) return null;

        int index = -1,  maxVal = Integer.MIN_VALUE;
        for(int i=low; i<=high; i++) {
            if(nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = build(nums, low, index-1);
        root.right = build(nums, index+1, high);
        return root;
    }
}
