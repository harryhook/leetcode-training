package com.leetcode.training;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_54_SpiralOrder {

    public static void main(String[] args) {

        LeetCode_54_SpiralOrder client = new LeetCode_54_SpiralOrder();

        int[][] matrix = {{1,2}, {3,4}};

        System.out.println( client.spiralOrder(matrix));;
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        // 思路： 向左 ->  向下 -> 向右 -> 向上 -> 向左
        List<Integer> res = new ArrayList<>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0, rowEnd = matrix.length - 1;
        int colBegin = 0, colEnd = matrix[0].length - 1;


        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int col = colBegin; col <= colEnd; col++) {
                res.add(matrix[rowBegin][col]);
            }
            rowBegin++;

            for (int row = rowBegin; row <= rowEnd; row++) {
                res.add(matrix[row][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int col = colEnd; col >= colBegin; col--) {
                    res.add(matrix[rowEnd][col]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                for (int row = rowEnd; row >= rowBegin; row--) {
                    res.add(matrix[row][colBegin]);
                }
            }
            colBegin++;
        }

        return res;
    }


}
