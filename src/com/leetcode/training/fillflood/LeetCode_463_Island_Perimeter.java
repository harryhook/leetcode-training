package com.leetcode.training.fillflood;

public class LeetCode_463_Island_Perimeter {
    public static void main(String[] args) {
        LeetCode_463_Island_Perimeter client = new LeetCode_463_Island_Perimeter();
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(client.islandPerimeter(grid));
    }

    public int islandPerimeter1(int[][] grid) {

        //第一种解法， 岛屿有四条边，两个岛屿相交需要减去两条边
        int land = 0, board = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    land++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        board++;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                        board++;
                    }
                }
            }
        }
        return 4 * land - 2 * board;
    }

    public int islandPerimeter(int[][] grid) {

        //第二种解法， 陆地向四周遍历， 陆地之间不产生周长，陆地到海洋，陆地到边界都会产生周长
        // 像四周遍历的过程中会存在重复遍历， 所以遍历过的陆地需要进行标记

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return 1;
        if (grid[x][y] == 0) return 1;
        if (grid[x][y] == 2) return 0;
        // 访问过的标记一下
        grid[x][y] = 2;
        return dfs(grid, x + 1, y) + dfs(grid, x - 1, y) + dfs(grid, x, y + 1) + dfs(grid, x, y - 1);

    }
}
