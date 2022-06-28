package com.leetcode.training.matrix;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_58_SpiralMatrixII {

    int num = 1;

    public static void main(String[] args) {

        LeetCode_58_SpiralMatrixII client = new LeetCode_58_SpiralMatrixII();


        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(client.printMatrix(matrix));
    }


    public List<Integer> printMatrix(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int rowStart = 0, rowEnd = m - 1, colStart = 0, colEnd = n - 1;
        // 终止条件
        while (list.size() < m * n) {
            // 从第一行开始打印
            if (rowStart <= rowEnd) {
                for (int col = colStart; col <= colEnd; col++) {
                    list.add(matrix[rowStart][col]);
                }
                rowStart++;
            }

            // 从最后一列开始打印
            if (colStart <= colEnd) {
                for (int row = rowStart; row <= rowEnd; row++) {
                    list.add(matrix[row][colEnd]);
                }
                colEnd--;
            }

            // 从最后一行开始打印
            if (rowStart < rowEnd) {
                for (int col = colEnd; col >= colStart; col--) {
                    list.add(matrix[rowEnd][col]);
                }
                rowEnd--;

            }

            // 从第一列开始打印
            if (colStart <= colEnd) {
                for (int row = rowEnd; row >= rowStart; row--) {
                    list.add(matrix[row][colStart]);
                }
                colStart++;

            }

        }
        return list;
    }


}
