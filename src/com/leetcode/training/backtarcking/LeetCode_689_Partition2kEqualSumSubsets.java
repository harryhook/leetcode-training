package com.leetcode.training.backtarcking;

import java.util.Arrays;

/**
 * @author haowei.chen
 * @date 2022/12/14 23:16
 * @desc
 */
public class LeetCode_689_Partition2kEqualSumSubsets {


    public static void main(String[] args) {
        LeetCode_689_Partition2kEqualSumSubsets client = new LeetCode_689_Partition2kEqualSumSubsets();

        System.out.println(client.canPartitionKSubsets(new int[]{3, 3, 10, 2, 6, 5, 10, 6, 8, 3, 2, 1, 6, 10, 7, 2}, 6));

    }

    public boolean canPartitionKSubsets(int[] nums, int k) {

        if (nums.length < k) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
       
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            // 交换 nums[i] 和 nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        boolean[] used = new boolean[nums.length];
        return backtrack(k, 0, nums, 0, target, used);
    }

    private boolean backtrack(int k, int bucket, int[] nums, int start, int target, boolean[] used) {
       // 桶都填满了
        if(k == 0) {
            return true;
        }
        // 当前桶填满了，递归下一个通
        if(bucket == target) {
            return backtrack(k - 1, 0, nums, 0, target, used);
        }
        for (int i = start; i < nums.length; i++) {
            //nums[i] 已经被使用过了，跳过
            if(used[i]) {
                continue;
            }
            //当前桶装不下nums[i]
            if(bucket + nums[i] > target) {
                continue;
            }
            used[i] = true;
            if(backtrack(k, bucket + nums[i], nums, i + 1, target, used)) {
                return true;
            }
            used[i] = false;
        }

        return false;
    }


    public boolean canPartitionKSubsets1(int[] nums, int k) {

        if (nums.length < k) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            // 交换 nums[i] 和 nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return backtrack1(nums, new int[k], 0, target);
    }

    private boolean backtrack1(int[] nums, int[] bucket, int index, int target) {

        // 递归终止条件
        if (index == nums.length) {
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != target) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < bucket.length; i++) {
            // 当前分支不满足，剪枝
            if (bucket[i] + nums[index] > target) {
                continue;
            }
            bucket[i] += nums[index];
            // 如果当前分支满足，继续递归
            if (backtrack1(nums, bucket, index + 1, target)) {
                return true;
            }
            bucket[i] -= nums[index];
        }

        return false;
    }
}
