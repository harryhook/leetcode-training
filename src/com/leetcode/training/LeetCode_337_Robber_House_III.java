package com.leetcode.training;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_337_Robber_House_III {

//    public int rob(TreeNode root) {
//        if (root == null) return 0;
//
//        return robHelper(root, new HashMap<>());
//    }
    public int robHelper(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;

        int ans = 0;
        if(map.get(root) != null) return map.get(root);

        // max value from left grandchildren
        if (root.left != null) {
            ans += robHelper(root.left.left, map) + robHelper(root.left.right, map);
        }

        // max value from right grandchildren
        if (root.right != null) {
            ans += robHelper(root.right.left, map) + robHelper(root.right.right, map);
        }

        ans = Math.max(ans + root.val, robHelper(root.left, map) + robHelper(root.right, map));

        map.put(root, ans);

        return ans;
    }


    public int rob(TreeNode root) {
        int ans[] = robHouse(root);
        return Math.max(ans[0],ans[1]);
    }

    public int[] robHouse(TreeNode root){
        if(root==null){
            return new int[2];
        }

        int left[] = robHouse(root.left);
        int right[] = robHouse(root.right);

        int ans[] = new int[2];

        ans[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        ans[1] = root.val+left[0]+right[0];

        return ans;
    }

    public static void main(String[] args) {
            LeetCode_337_Robber_House_III client = new LeetCode_337_Robber_House_III();
            TreeNode root = new TreeNode(3);

            TreeNode left1 = new TreeNode(2);
            TreeNode right1 = new TreeNode(3);

            root.left = left1;
            root.right = right1;

            TreeNode right12 = new TreeNode(3);
            left1.right = right12;

            TreeNode right21 = new TreeNode(1);
            right1.right = right21;

            client.rob(root);
    }
}
