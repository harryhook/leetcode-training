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

import java.util.Arrays;

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
        if (preorder == null || preorder.length ==0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = 0;
        for(int i=0; i<inorder.length; i++) {
            if(preorder[0] == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        // 数组分割 [根，左，右]， [左，根，右]
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, 1+rootIndex);
        int[] rightPreOrder = Arrays.copyOfRange(preorder,  1+rootIndex, preorder.length);

        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] rightInOrder = Arrays.copyOfRange(inorder,  1+rootIndex, inorder.length);
        // 更直观解法， 前序遍历第一个节点是根节点，然后在中序遍历中找到根节点， 根节点左边是左子树， 根节点右边是右子树

        root.left = buildTree(leftPreOrder, leftInOrder);
        root.right = buildTree(rightPreOrder, rightInOrder);

        return root;
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
        int leftTreeSize = inRoot - inLow;

        root.left = build(preorder, preLow + 1, preLow + leftTreeSize, inorder, inLow, inRoot - 1);
        root.right = build(preorder, preLow + leftTreeSize + 1, preHigh, inorder, inRoot + 1, inHigh);

        return root;
    }
}
