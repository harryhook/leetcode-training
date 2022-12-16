package com.leetcode.training.graph;

/**
 * @author haowei.chen
 * @date 2022/12/11 20:50
 * @desc
 */
public class LeetCode_130_SurroundedRegions {

    public static void main(String[] args) {
        LeetCode_130_SurroundedRegions client = new LeetCode_130_SurroundedRegions();
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        client.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solve1(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        // 第一列， 最后一列
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        //第一行，最后一行
        for(int i=1; i<n-1; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }

        for(int i=0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x - 1, y);
        dfs(board, x + 1, y);
        dfs(board, x, y - 1);
        dfs(board, x, y + 1);
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        UnionFind uf = new UnionFind(m * n + 1);
        int dummy = m * n;

        //  第一列，最后一列的 'O' 进行处理， 用UF进行标记
        for(int i=0; i<m; i++) {
            if(board[i][0] == 'O') {
                uf.union(i*n, dummy);
            }
            if(board[i][n-1] == 'O') {
                uf.union(i*n+n-1, dummy);
            }
        }
        //找到第一行， 最后一行，
        for(int i=0; i<n; i++) {
            if(board[0][i] == 'O') {
                uf.union(i, dummy);
            }
            if(board[m-1][i] == 'O') {
                uf.union((m-1)*n+i, dummy);
            }
        }
        // 再从矩阵内部一次遍历，上下左右元素，如果出现'O' 被继续标记
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int i=1; i<m-1; i++) {
            for(int j = 1; j<n-1; j++) {
                if(board[i][j] == 'O') {
                    for(int k=0; k<4; k++) {
                        int x = i+directions[k][0];
                        int y = j+directions[k][1];
                        if(board[x][y] == 'O') {
                            uf.union(x*n+y, i*n+j);
                        }
                    }
                }
            }
        }
        // 对整个矩阵元素进行打标， 非UF集合的元素置为 'X'
        for(int i=1; i<m-1; i++) {
            for(int j=1; j<n-1; j++) {
                if(!uf.connected(i*n+j, dummy)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}


/**
 * 最基础的UF算法， 还可以对层高进行优化
 */
class UnionFind {

    // 并查集联通量
    private int count = 0;

    private int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        // 最开始n个节点互不相通
        this.count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        // parent[rootQ] = rootP;
        count--;
    }

    public int find(int p) {
        // parent[p] == p 说明p是根节点
        while (p != parent[p]) {
            p = parent[p];
        }

        return p;
    }

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        return rootP == rootQ;
    }

    public int count() {
        return count;
    }

}