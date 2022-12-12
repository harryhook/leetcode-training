package com.leetcode.training.graph;

/**
 * @author haowei.chen
 * @since 2022/12/9 22:34
 */
public class LeetCode_785_IsGraphBipartite {

    private boolean ok = true;

    /**
     * 记录是否被访问过
     */
    private boolean[] visited;
    /**
     * 记录对应节点的颜色
     */
    private boolean[] color;

    public boolean isBipartite(int[][] graph) {
        visited = new boolean[graph.length];
        color = new boolean[graph.length];
        // 每个节点都需要访问到
        for (int v = 0; v < graph.length; v++) {
            traverse(graph, v);
        }
        return ok;
    }

    private void traverse(int[][] graph, int v) {
        // 如果已经不满足条件了直接返回
        if (!ok) {
            return;
        }
        // 标记当前节点为已访问， 再访问相邻节点
        visited[v] = true;
        for (int w : graph[v]) {
            // 如果相邻节点没有被访问过，继续访问相邻节点，并进行标记
            if (!visited[w]) {
                color[w] = !color[v];
                traverse(graph, w);
            } else {
                // 如果相邻节点被访问过，判断相邻节点的颜色与当前节点是否一致， 如果一致，直接返回
                if(color[v] == color[w]) {
                    ok = false;
                    return;
                }
                // 循环继续访问下一个相邻节点
            }

        }

    }
}
