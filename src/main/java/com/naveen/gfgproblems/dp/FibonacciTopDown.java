package com.naveen.gfgproblems.dp;

import java.util.Arrays;

public class FibonacciTopDown {
    int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return fib(n, dp);
    }
    private int fib(int n, int[] dp) {
        if (dp[n] != -1) return dp[n];
        int res = -1;
        if (n == 0 || n == 1) res = n;
        else res = fib(n - 1) + fib(n - 2);
        dp[n] = res;
        return dp[n];
    }
}
