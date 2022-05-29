package com.leetcode.training;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LeetCode_128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        LeetCode_128_LongestConsecutiveSequence client = new LeetCode_128_LongestConsecutiveSequence();
        client.longestConsecutive(new int[]{100,4,200,1,3,2});
    }
    public int longestConsecutive(int[] nums) {

        Set<Integer> numSet =  Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int best = 0;
        for(Integer x: numSet) {
            if(!numSet.contains(x-1)) {
                int y = x + 1;
                while(numSet.contains(y)) {
                    y++;
                }
                best = Math.max(best, y-x);
            }
        }
        return best;
    }
}
