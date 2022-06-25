package com.leetcode.training.fillflood;

public class LeetCode_733_Flood_Fil {
    public static void main(String[] args) {
        LeetCode_733_Flood_Fil client = new LeetCode_733_Flood_Fil();
        int[][] grid = {{2,2,2},{2,1,2},{2,2,2}};
        System.out.println(client.floodFill(grid, 1, 1, 2));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originColor = image[sr][sc];

        fill(image, sr, sc, originColor, color);

        return image;
    }
    public void fill(int[][] image, int x, int y, int originColor,  int newColor) {
        if(x<0 || x >= image.length || y<0 || y>=image[0].length) return ;
        if(image[x][y] != originColor) return ;
        if(image[x][y] == -1) return ;

        image[x][y] = -1;
        fill(image, x-1, y, originColor, newColor);
        fill(image, x+1, y, originColor, newColor);
        fill(image, x, y-1, originColor, newColor);
        fill(image, x, y+1, originColor, newColor);
        image[x][y] = newColor;


    }
}
