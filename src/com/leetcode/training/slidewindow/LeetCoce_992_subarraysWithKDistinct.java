package com.leetcode.training.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haowei.chen
 * @since 2024/5/25 16:33
 * 示例 1：
 *
 * 输入：nums = [1,2,1,2,3], k = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * 示例 2：
 *
 * 输入：nums = [1,2,1,3,4], k = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 *
 */
public class LeetCoce_992_subarraysWithKDistinct {

    public static void main(String[] args) {
        LeetCoce_992_subarraysWithKDistinct client = new LeetCoce_992_subarraysWithKDistinct();
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(client.subarraysWithKDistinct(nums, k));
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostKDistinct(A, K) - atMostKDistinct(A, K - 1);
    }

    private int atMostKDistinct(int[] A, int K) {
        int n = A.length;
        int left = 0, right = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (right < n) {
            map.put(A[right], map.getOrDefault(A[right], 0) + 1);
            while (map.size() > K) {

                map.put(A[left], map.get(A[left]) - 1);
                if (map.get(A[left]) == 0) {
                    map.remove(A[left]);
                }
                left++;
            }
            // 这个窗口的长度就代表了此时最多有k个不同数字的子数组的个数
            count += right - left + 1;
            right++;
        }

        return count;
    }



}
