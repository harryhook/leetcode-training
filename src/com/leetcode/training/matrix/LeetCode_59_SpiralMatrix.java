package com.leetcode.training.matrix;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_59_SpiralMatrix {

    int num = 1;

    public static void main(String[] args) {

        LeetCode_59_SpiralMatrix client = new LeetCode_59_SpiralMatrix();


        int[][] matrix = client.generateMatrix(3);
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }
        System.out.println(client.num);
    }


    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        // 思路： 向左 ->  向下 -> 向右 -> 向上 -> 向左
        List<Integer> res = new ArrayList<>();

        int[][] matrix = new int[n][n];

        int colBegin = 0, colEnd = n - 1;
        int rowBegin = 0, rowEnd = n - 1;


        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int col = colBegin; col <= colEnd; col++) {
                matrix[rowBegin][col] = num++;
            }
            rowBegin++;

            for (int row = rowBegin; row <= rowEnd; row++) {
                matrix[row][colEnd] = num++;
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int col = colEnd; col >= colBegin; col--) {
                    matrix[rowEnd][col] = num++;
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                for (int row = rowEnd; row >= rowBegin; row--) {
                    matrix[row][colBegin] = num++;
                }
            }
            colBegin++;
        }

        return matrix;
    }


}
