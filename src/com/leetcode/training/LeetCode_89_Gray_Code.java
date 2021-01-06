package com.leetcode.training;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhaowei
 * @date 2020.12.20
 */
public class LeetCode_89_Gray_Code {

    public static void main(String[] args) {
        LeetCode_89_Gray_Code client = new LeetCode_89_Gray_Code();
        client.grayCode(3).forEach(o-> System.out.println(o));




    }

    public List<Integer> grayCode(int n) {
        List<Integer> rs = new ArrayList<Integer>();
        rs.add(0);
        for (int i = 0; i < n; i++) {
            int size = rs.size();
            for (int k = size - 1; k >= 0; k--)
                rs.add(rs.get(k) | 1 << i);
        }

        return rs;
    }
}
