package com.leetcode.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_210_Course_Schedule_II {

    public static void main(String[] args) {
        LeetCode_210_Course_Schedule_II courseSchedule = new LeetCode_210_Course_Schedule_II();

        int[] result = courseSchedule.findOrder(2, new int[][]{{1,0}});

        for(int num: result) {
            System.out.println(num);
        }
    }

    private boolean[] visited;
    private boolean[] onPath;
    private boolean hasCycle = false;
    private List<Integer> res = new ArrayList<>();


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        // build graph
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        // dfs 遍历，如果已经遍历过的节点被再次遍历到即不可以，，循环完所有节点返回结果即可
        for(int i=0; i<numCourses; i++) {
            traverse(i, graph);
        }
        if(hasCycle) {
            return new int[]{};
        }
        int[] result = new int[res.size()];
        for(int i = 0; i<res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }

    private void traverse(int cur, List<Integer>[] graph) {
        // 节点已在访问路径上，返回false， 不可能完成
        if(onPath[cur]) {
            hasCycle = true;
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
        res.add(cur);
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

    public int[] canFinish(int numCourses, int[][] prerequisites) {

        int[] degree = new int[numCourses];
        int[] finishCourse = new int[numCourses];
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
            finishCourse[cnt] = course;
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
        return cnt == numCourses? finishCourse: new int[]{};
    }
}
