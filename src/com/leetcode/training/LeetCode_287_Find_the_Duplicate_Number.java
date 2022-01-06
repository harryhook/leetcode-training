package com.leetcode.training;

public class LeetCode_287_Find_the_Duplicate_Number {


    public static void main(String[] args) {
        LeetCode_287_Find_the_Duplicate_Number client = new LeetCode_287_Find_the_Duplicate_Number();

        int result = client.findDuplicate(new int[]{1,2,2,3,4,5});
        System.out.println(result);

    }

    public int findDuplicate2(int[] nums) {
        /**
         * 循环链表思路
         *
         * fast = slow
         *
         * slow = x + y
         * fast = x + y +z
         *
         * 2x+2y = x + y + z  -> x+y = z   x = z-y 相遇点
         */
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public int findDuplicate(int[] nums) {

        /**
         *  n 个数  1-n-1
         *
         *  1,2,2,3,4,5
         *  二分mid = 2  如果小于2的数大于2， 则说明mid左侧有重复数据
         *  high = mid
         *  否则
         *  low = mid + 1
         */

        int low = 0, high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;
            int n = 0;
            for (int num : nums) {
                if (num <= mid) {
                    n ++;
                }
            }
            if (n <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
