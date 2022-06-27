package com.leetcode.training.fillflood;

public class LeetCode_1034_Coloring_A_Border {
    public static void main(String[] args) {
        LeetCode_1034_Coloring_A_Border client = new LeetCode_1034_Coloring_A_Border();
        int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        client.colorBorder(grid, 1, 1, 2);
        for (int[] ints : grid) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public void colorBorder(int[][] grid, int r0, int c0, int color) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        dfs(grid, r0, c0, color, visited, dirs);
    }

    public void dfs(int[][] grid, int r, int c, int color, int[][] visited, int[][] dirs) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return;
        if (visited[r][c] == 1) return;
        visited[r][c] = 1;
        int flag = 0;
        // 四个方向挨个遍历一遍
        for (int[] dir : dirs) {
            int x = r + dir[0];
            int y = c + dir[1];
            if (inBound(grid, x, y) && visited[x][y] == 0 && grid[r][c] == grid[x][y]) {
                dfs(grid, x, y, color, visited, dirs);
            }
            // inbound  && visited
            if (inBound(grid, x, y) && visited[x][y] == 1) {
                flag++;
            }
        }
        // 是连通量且不是边界，则颜色为color
        if (flag != 4) {
            grid[r][c] = color;
        }
    }

    private boolean inBound(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
