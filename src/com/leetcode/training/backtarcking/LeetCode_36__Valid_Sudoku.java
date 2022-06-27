package com.leetcode.training.backtarcking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chenhaowei
 * @date 2021.09.14
 * 这个题意满足当前行无重复数据， 当前列无重复数据 当前块无重复数据即可
 */
public class LeetCode_36__Valid_Sudoku {

    public static void main(String[] args) {
        LeetCode_36__Valid_Sudoku client = new LeetCode_36__Valid_Sudoku();

        char[][] board = {
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};

        System.out.println(client.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowSee = new HashMap<>(), colSee = new HashMap<>(), areaSee = new HashMap<>();

        for (int i = 0; i < board[0].length; i++) {
            rowSee.put(i, new HashSet<>());
            colSee.put(i, new HashSet<>());
            areaSee.put(i, new HashSet<>());
        }


        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                char curr = board[i][j];
                if (curr != '.') {
                    if (rowSee.get(i).contains(curr) || colSee.get(j).contains(curr) || areaSee.get(i / 3 * 3 + j / 3).contains(curr)) {
                        return false;
                    }
                    rowSee.get(i).add(curr);
                    colSee.get(i).add(curr);
                    areaSee.get(i / 3 * 3 + j / 3).add(curr);
                }

            }
        }
        return true;
    }
}
