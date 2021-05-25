package com.leetcode.training;

public class LeetCode_79_World_Search {
    public static void main(String[] args) {


    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    return helper(board, i, j, 0, word);
                }
            }
        }

        return false;
    }

    private boolean helper(char[][] board, int i, int j, int index, String word) {
        if (index == word.length() - 1) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;

        char temp = board[i][j];
        board[i][j]= '0';
        boolean result = helper(board, i+1, j, index+1, word)
                || helper(board, i-1, j, index+1, word)
                ||helper(board, i, j+1, index+1, word)
                || helper(board, i, j-1, index+1, word);
        board[i][j] = temp;
        return result;
    }
}
