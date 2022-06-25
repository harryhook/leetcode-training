package com.leetcode.training.stack;

import java.util.Stack;

public class LeetCode_76_SimplePath {
    public static void main(String[] args) {

        String s = "/../";

        System.out.println(new LeetCode_76_SimplePath().simplifyPath(s));

    }

    public String simplifyPath(String path) {

        String[] patterns = path.split("/");
        Stack<String> stack = new Stack<>();    // 存放路径
        for (String pattern : patterns) {
            if(pattern.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else if(!pattern.equals(".") && !pattern.isEmpty()) {
                stack.push(pattern);
            }
        }
        String res = "";
        while(!stack.isEmpty()) {
           res = "/" + stack.pop() + res;
        }
        return res.length() == 0? "/": res;
    }
}
