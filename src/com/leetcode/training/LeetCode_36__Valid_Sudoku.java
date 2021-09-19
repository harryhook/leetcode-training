package com.leetcode.training;

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

        System.out.println(client.isValidSudoku(board));;
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
}
