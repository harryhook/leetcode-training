package com.leetcode.training.binarysearch;


/**
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had received 0, 1, 3, 5, 6 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 */
public class LeetCode_275_HIndexII {
    /**
     * 求h指数，总共有 h 篇论文分别被引用了至少 h 次
     * h = len-high
     * len-mid <= a[mid] 为边界
     * [0,1,3,5,6]
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int length = citations.length;
        int low = -1, high = length;
        while(low + 1 != high) {
            int mid = low + (high -low) /2;
            if(length - mid <= citations[mid]) {
                high = mid;
            } else{
                low = mid;
            }
        }
        return length-high;
    }

    public static void main(String[] args) {
        LeetCode_275_HIndexII client = new LeetCode_275_HIndexII();

        System.out.println( client.hIndex(new int[]{0}));
    }
}
