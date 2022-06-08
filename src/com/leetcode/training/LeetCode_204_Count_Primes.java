package com.leetcode.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_204_Count_Primes {


    public static void main(String[] args) {
        LeetCode_204_Count_Primes findAllNums = new LeetCode_204_Count_Primes();
        System.out.println(findAllNums.findPrimes(12));
    }

    /**
     * n， 求n以内的质数列表
     * 质数只能被1和自身整除， 不能分解
     * eg: 2,3,5,7,11,13,17,19
     */
    public List<Integer> findPrimes(int n) {

        if (n <= 1) return new ArrayList<>();
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for(int i=2; i<n; i++) {
            if(isPrime[i]) res.add(i);
        }

        return res;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 有序集合，求并集
    public List<Integer> findIntersction(List<Integer> list1, List<Integer> list2) {


        int left = 0, right = 0;
        List<Integer> res = new ArrayList<>();

        while (right < list2.size()) {
            // 双指针


        }


        return res;

    }

}
