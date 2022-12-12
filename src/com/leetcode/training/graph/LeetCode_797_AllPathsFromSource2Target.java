package com.leetcode.training.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haowei.chen
 * @since 2022/12/8 00:17
 */
public class LeetCode_797_AllPathsFromSource2Target {

    public static void main(String[] args) {
        LeetCode_797_AllPathsFromSource2Target client = new LeetCode_797_AllPathsFromSource2Target();
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(client.allPathsSourceTarget(graph));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, res);

        return res;
    }

    private void dfs(int[][] graph, int cur, List<Integer> path, List<List<Integer>> res) {
        // 走到最后一个位置，记录满足条件的路径
        if(cur == graph.length - 1) {
            // 利用深拷贝，防止path被修改
            res.add(new ArrayList<>(path));
            return;
        }

        for (int next : graph[cur]) {
            path.add(next);
            dfs(graph, next, path, res);
            path.remove(path.size() - 1);
        }

    }
}
