package com.leetcode.training;

import java.util.HashMap;

public class LeetCode_437_LeetCode_Path_Sum_III {

    private  int count = 0;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);

        TreeNode left1 = new TreeNode(5);
        TreeNode right1 = new TreeNode(-3);

        root.left = left1;
        root.right = right1;

        TreeNode left21 = new TreeNode(3);
        TreeNode left22 = new TreeNode(2);
        left1.left = left21;
        left1.right = left22;

        TreeNode right22 = new TreeNode(11);
        right1.right = right22;


        TreeNode left31 = new TreeNode(3);
        TreeNode left32 = new TreeNode(-2);
        left21.left = left31;
        left21.right = left32;


        TreeNode right33 = new TreeNode(1);
        left22.right = right33;

        LeetCode_437_LeetCode_Path_Sum_III client = new LeetCode_437_LeetCode_Path_Sum_III();
        System.out.println( client.pathSum1(root, 8));


    }

    public int pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return 0;
        }
        preOrder(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return count;
    }

    private void preOrder(TreeNode root, int targetSum) {

        if (root == null) return;

        if (targetSum == root.val) {
            count++;
        }

        int subSum = targetSum - root.val;

        preOrder(root.left , subSum);
        preOrder(root.right, subSum);
    }

    public int pathSum1(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        helper(root, 0, sum, preSum);
        return count;
    }
    public void helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return;
        }

        currSum += root.val;

        if (preSum.containsKey(currSum - target)) {
            count += preSum.get(currSum - target);
        }

        if (!preSum.containsKey(currSum)) {
            preSum.put(currSum, 1);
        } else {
            preSum.put(currSum, preSum.get(currSum)+1);
        }

        helper(root.left, currSum, target, preSum);
        helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
    }
}
