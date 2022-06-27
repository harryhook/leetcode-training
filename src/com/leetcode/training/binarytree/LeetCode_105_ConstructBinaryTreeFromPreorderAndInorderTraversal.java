package com.leetcode.training.binarytree;

/**
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */

import com.leetcode.training.TreeNode;

/**
 * @author chenhaowei
 * @date 2021.11.11
 */
public class LeetCode_105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        LeetCode_105_ConstructBinaryTreeFromPreorderAndInorderTraversal client = new LeetCode_105_ConstructBinaryTreeFromPreorderAndInorderTraversal();

        client.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        /**
         * 递归思路， 前序数组的pre[0] 是root， 找到pre[0] 在中序数组的位置即为root的右子树， 剩余部分为root的左子树
         */
        if (preorder.length != inorder.length) return null;

        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh) {
        if (preLow > preHigh || inLow > inHigh) return null;

        TreeNode root = new TreeNode(preorder[preLow]);

        int inRoot = inLow;

        for (int i = inLow; i <= inHigh; i++) {
            if (root.val == inorder[i]) {
                inRoot = i;
            }
        }
        int leftTreeLength = inRoot - inLow;

        root.left = build(preorder, preLow + 1, preLow + leftTreeLength, inorder, inLow, inRoot - 1);
        root.right = build(preorder, preLow + leftTreeLength + 1, preHigh, inorder, inRoot + 1, inHigh);

        return root;
    }
}
