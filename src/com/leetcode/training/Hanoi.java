package com.leetcode.training;

/**
 * @author haowei.chen
 * @since 2023/2/25 22:42
 */
public class Hanoi {

    public void hanoi(int n, char from, char to, char temp) {
        if (n == 1) {
            System.out.println("move " + n + " from " + from + " to " + to);
        } else {
            hanoi(n - 1, from, temp, to);
            System.out.println("move " + n + " from " + from + " to " + to);
            hanoi(n - 1, temp, to, from);
        }
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.hanoi(2, 'A', 'C', 'B');
    }
}
