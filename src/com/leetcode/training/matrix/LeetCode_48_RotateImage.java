package com.leetcode.training.matrix;

public class LeetCode_48_RotateImage {

    public static void main(String[] args) {

        LeetCode_48_RotateImage client = new LeetCode_48_RotateImage();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        client.rotate(matrix);
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

    // 镜像交换后行交换
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // 镜像交换
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;


            }
        }

        // swap col
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][col - j - 1];
                matrix[i][col - j - 1] = temp;

            }
        }

    }
}
