package com.leetcode.training;

import java.util.ArrayList;

public class LeetCode_73_Set_Matrix_Zeroes {

    public static void main(String[] args) {
        int[][] matrix = {{-4, -2147483648, 6, -7, 0}, {-8, 6, -8, -6, 0}, {2147483647, 2, -9, -6, -10}};

        LeetCode_73_Set_Matrix_Zeroes client = new LeetCode_73_Set_Matrix_Zeroes();

        client.setZeroes1(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf(matrix[i][j] + ",");
            }
            System.out.println();
        }
    }


    public void setZeroes1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstColIsZero = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) firstColIsZero = true;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int row = m - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 1; col--) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
            if (firstColIsZero) matrix[row][0] = 0;
        }

    }

    public void setZeroes(int[][] matrix) {

        if (matrix == null || matrix.length == 0) return;

        int m = matrix.length;
        int n = matrix[0].length;

        ArrayList<Position> positions = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    positions.add(new Position(i, j));
                }
            }
        }
        for (Position position : positions) {
            for (int row = 0; row < m; row++) {
                matrix[row][position.getCol()] = 0;
            }
            for (int col = 0; col < n; col++) {
                matrix[position.getRow()][col] = 0;
            }
        }

    }

    static class Position {
        private int row;
        private int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }
    }
}
