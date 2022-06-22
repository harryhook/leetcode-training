package com.leetcode.training.backtarcking;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenhaowei
 * @date 2021.09.14
 */
public class LeetCode_36__Valid_Sudoku {

    public static void main(String[] args) {
        LeetCode_36__Valid_Sudoku client = new LeetCode_36__Valid_Sudoku();

        char[][] board = {
                  {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(client.isValidSudoku2(board));
    }

    public boolean isValidSudoku(char[][] board) {
        Set<String> see = new HashSet<>();
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                char curr = board[i][j];
                if (curr != '.') {
                    String b = "(" + curr + ")";
                    if (!see.add(b + "" + i) || !see.add(j + "" + b) || !see.add(i / 3 + "" + b + j / 3)) {
                        return false;
                    }
                }

            }
        }
        return true;
    }

    public char[][] isValidSudoku2(char[][] board) {

        backtrack(board, 0, 0);
        return board;
    }

    private boolean backtrack(char[][] board, int i, int j) {
        int m = 9, n = 9;

        // 走到了棋盘最后,找到了可行解
        if (i == m) {
            return true;
        }
        // 走到最后一列， 继续往下一行走
        if (j == n) {
            return backtrack(board, i + 1, 0);
        }


        if (board[i][j] != '.') {
            return backtrack(board, i, j + 1);
        }
        // 开始穷举当前数字
        for (char ch = '1'; ch <= '9'; ch++) {
            // 遇到不合法数组， 跳过
            if (!isValid(board, i, j, ch)) {
                continue;
            }
            board[i][j] = ch;
            // 找到一个可行解，结束
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            // 回溯
            board[i][j] = '.';
        }
        // 1~9 都走完了还未找到，返回false
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            // 行有没有重复
            if (board[row][i] == ch) return false;
            // 列有没有重复
            if (board[i][col] == ch) return false;
            // 3* 3 的格子有没有重复
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == ch) return false;
        }
        return true;

    }
}
