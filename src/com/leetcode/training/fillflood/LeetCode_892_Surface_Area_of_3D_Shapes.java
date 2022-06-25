package com.leetcode.training.fillflood;

public class LeetCode_892_Surface_Area_of_3D_Shapes {
    public static void main(String[] args) {
        LeetCode_892_Surface_Area_of_3D_Shapes client = new LeetCode_892_Surface_Area_of_3D_Shapes();
        int[][] grid = {{2,2,2},{2,1,2},{2,2,2}};
        System.out.println(client.surfaceArea(grid));
    }

    public int surfaceArea(int[][] grid) {
        // 正方体的面积 6n. 如果两个正方体相交， 面积-2
        int cubes = 0, faces = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                cubes += grid[i][j];
                // n个cube 重叠有n-1个面重合
                if(grid[i][j] > 1) {
                    faces += grid[i][j] -1;
                }
                if(i > 0) {
                    faces += Math.min(grid[i-1][j], grid[i][j]);
                }
                if(j > 0) {
                    faces += Math.min(grid[i][j-1], grid[i][j]);
                }
            }
        }
        return cubes*6 - 2*faces;
    }
}
