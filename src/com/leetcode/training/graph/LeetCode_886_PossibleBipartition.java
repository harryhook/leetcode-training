package com.leetcode.training.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haowei.chen
 * @since 2022/12/9 23:08
 */
public class LeetCode_886_PossibleBipartition {

    private boolean ok = true;
    /**
     * 记录是否被访问过
     */
    private boolean[] visited;
    /**
     * 记录对应节点的颜色
     */
    private boolean[] color;

    public boolean possibleBipartition(int n, int[][] dislikes) {

        visited = new boolean[n + 1];
        color = new boolean[n + 1];
        List<Integer>[] graph = buildGraph(n, dislikes);
        for (int v = 1; v <= n; v++) {
            traverse(graph, v);
        }
        return ok;
    }

    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n + 1];
        // 节点是从1开始的
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] nums : dislikes) {
            int v = nums[0];
            int w = nums[1];
            // 建立双相连接
            graph[v].add(w);
            graph[w].add(v);
        }

        return graph;
    }


    private void traverse(List<Integer>[] graph, int v) {
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
                if (color[v] == color[w]) {
                    ok = false;
                    return;
                }
                // 循环继续访问下一个相邻节点
            }

        }
    }

    public static void main(String[] args) {
        LeetCode_886_PossibleBipartition client = new LeetCode_886_PossibleBipartition();

        boolean res = client.possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}});
        System.out.println(res);
    }
}
