package com.leetcode.training;


import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhaowei
 * @date 2020.08.06
 */
public class LeetCode_51_N_Queenes {

    public static void main(String[] args) {
        LeetCode_51_N_Queenes client = new LeetCode_51_N_Queenes();
        System.out.println(client.nQueue(4).size());

    }

    public List<List<String>> nQueue(int n) {

        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '.';
            }
        }

        List<List<String>> res = new ArrayList<>();

        dfs(res, matrix, 0);

        res.forEach( o->{
            o.forEach( m-> {
                System.out.println(m);
            });
            System.out.println();
        });
        return res;
    }

    private void dfs(List<List<String>> res, char[][] matrix, int colIndex) {

        if (colIndex == matrix.length) {
            res.add(construct(matrix));
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (valid(matrix, i, colIndex)) {
                matrix[i][colIndex] = 'Q';
                dfs(res, matrix, colIndex + 1);
                matrix[i][colIndex] = '.';
            }
        }
    }

    private boolean valid(char[][] matrix, int x, int y) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 'Q' && (x + y == i + j || x + j == i + y || x == i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> construct(char[][] matrix) {
        List<String> sub = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb = new StringBuilder("\"");
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j]);
            }
            sb.append("\"");
            sub.add(sb.toString());
        }
        return sub;
    }
}
