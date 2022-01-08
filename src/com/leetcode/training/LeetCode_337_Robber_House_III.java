package com.leetcode.training;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_337_Robber_House_III {

    public int rob(TreeNode root) {
        if (root == null) return 0;

        return robHelper(root, new HashMap<>());
    }
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
}
