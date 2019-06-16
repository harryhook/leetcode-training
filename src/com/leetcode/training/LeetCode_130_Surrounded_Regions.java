package com.leetcode.training;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author chenhaowei
 * @date 2019.06.15
 */
public class LeetCode_130_Surrounded_Regions {
    public static void solve(char[][] board) {

        if (board.length <= 0 || board[0].length < 0) {
            return;
        }
        int rows = board.length;
        int columns = board[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if ( (board[i][j] == 'O' ) && (i == 0 || i == rows - 1 || j == 0 || j == columns - 1)) {

                    Queue<Point> points = new LinkedList<>();
                    points.offer(new Point(i, j));
                    board[i][j] = 'R';
                    while (!points.isEmpty()) {
                        Point point = points.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = directions[k][0] + point.x;
                            int y = directions[k][1] + point.y;
                            if (x >= 0 && x < rows && y >= 0 && y < columns && board[x][y] == 'O') {
                                points.offer(new Point(x, y));
                                board[x][y] = 'R';
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(board[i][j] == 'R') {
                    board[i][j] = 'O';
                }
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        char[][] board = new char[m][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 'O';
            }
        }

        solve(board);

    }

}

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
