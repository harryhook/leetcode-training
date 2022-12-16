package com.leetcode.training.bfs;

import com.leetcode.training.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author haowei.chen
 * @since 2022/12/16 22:51
 */
public class LeetCode_111_MinimumDepthBinaryTree {

    public static void main(String[] args) {
        LeetCode_111_MinimumDepthBinaryTree client = new LeetCode_111_MinimumDepthBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(client.minDepth(root));
    }

    public int minDepthDfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = minDepthDfs(root.left);
        int rightDepth = minDepthDfs(root.right);

        if (leftDepth == 0 || rightDepth == 0) {
            return leftDepth + rightDepth + 1;
        }

        return Math.min(leftDepth, rightDepth) + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 终点返回
                if (node.left == null && node.right == null) {
                    return res;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res++;
        }
        return res;
    }


}
