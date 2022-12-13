package com.leetcode.training.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_207_CourseSchedule {


    public static void main(String[] args) {
        LeetCode_207_CourseSchedule courseSchedule = new LeetCode_207_CourseSchedule();

        Boolean result = courseSchedule.canFinish(6, new int[][]{{4, 1}, {2, 1}, {4, 2}, {3,2}, {5, 4}, {5, 3}, {3, 4}});

        System.out.println(result);
    }

    private boolean canFinish = true;

    private boolean[] visited;
    private boolean[] onPath;


    public boolean canFinish1(int numCourses, int[][] prerequisites) {

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        // build graph
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        // dfs 遍历，如果已经遍历过的节点被再次遍历到即不可以，，循环完所有节点返回结果即可
        for(int i=0; i<numCourses; i++) {
            traverse(i, graph);
        }

        return canFinish;
    }

    private void traverse(int cur, List<Integer>[] graph) {
        // 节点已在访问路径上，返回false， 不可能完成
        if(onPath[cur]) {
            canFinish = false;
            return;
        }
        //节点已经被访问，无需再访问一次
        if (visited[cur]) {
            return;
        }
        visited[cur] = true;
        onPath[cur] = true;
        for(int next: graph[cur]) {
            traverse(next, graph);
        }
        //访问完毕，从path移出
        onPath[cur] = false;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new ArrayList[numCourses];
        // 初始化
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] numCourse: prerequisites ) {
            int from = numCourse[0];
            int to = numCourse[1];
            // 单向图
            graph[from].add(to);
        }
        return graph;

    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] degree = new int[numCourses];
        List<Integer>[] edges = new ArrayList[numCourses];

        // 先修课程的list
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {

            //[1,0], 先修0再修1, 把所有要修的课程存起来
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
            // 修一门课加一度
            degree[prerequisites[i][0]]++;
        }

        //BFS
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                // 没有选修课
                queue.offer(i);
            }
        }

        int cnt = 0; // 统计没有上过的课
        while (!queue.isEmpty()) {
            int course = queue.poll();
            cnt++;
            int n = edges[course].size();

            // 有n门课以当前course为先修课， course->n个其他课程
            for (int i = 0; i < n; i++) {
                int pointer = edges[course].get(i);
                degree[pointer]--;
                // 判断pointer课程是否入度为0
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                }

            }
        }
        return cnt == numCourses;

    }
}
