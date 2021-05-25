package com.leetcode.training;

public class LeetCode_91_Decode_Ways {

    public static void main(String[] args) {
        LeetCode_91_Decode_Ways client = new LeetCode_91_Decode_Ways();
        System.out.println(client.numDecodings("12"));
    }

    public int decodeWays(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];

        dp[0] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 1; i < n; i++) {
            int first = Integer.valueOf(s.substring(i, i + 1));
            int second = Integer.valueOf(s.substring(i - 1, i + 1));

            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }

            if (second >= 10 && second <= 26) {
                dp[i] += i >= 2 ? dp[i - 2] : 1;
            }

        }
        return dp[n - 1];
    }

    public int numDecodings(String s) {
        if(s== null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int [] dp = new int[n+1] ;

        dp[0] =1;
        dp[1] =1;

        for(int i=1; i<n; i++) {
            int cur =  s.charAt(i);
            int pre = s.charAt(i-1);

            if(cur==0 && ( pre==0 || pre*10+cur>26)) {
                return 0;
            } else if(pre == 0 || (pre*10 + cur) > 26) {
                dp[i+1] = dp[i];
            } else if(cur == 0) {
                dp[i+1] = dp[i-1];
            } else {
                dp[i+1] = dp[i] + dp[i-1];
            }
        }
        return dp[n];
    }
}
