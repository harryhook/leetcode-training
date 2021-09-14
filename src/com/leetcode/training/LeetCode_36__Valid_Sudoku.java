package com.leetcode.training;

/**
 * @author chenhaowei
 * @date 2021.09.14
 */
public class LeetCode_36__Valid_Sudoku {


    public static void main(String[] args) {
        LeetCode_36__Valid_Sudoku client = new LeetCode_36__Valid_Sudoku();

        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        client.isValidSudoku(board);
    }

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                char curr = board[i][j];
                if (curr == '.') continue;
                for (int p = i + 1; p < board[0].length; p++) {
                    if (curr == board[p][j]) {
                        return false;
                    }
                }
                for (int q = j + 1; q < board.length; q++) {
                    if (curr == board[i][q]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
