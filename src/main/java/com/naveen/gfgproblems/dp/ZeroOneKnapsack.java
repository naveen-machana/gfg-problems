package com.naveen.gfgproblems.dp;

// given a knapsack of size W, and given items with weights and values
// maximize the value by collecting the items such that total weight of the collected items does not exceed the bag size
public class ZeroOneKnapsack {

    int knapsack01(int[] v, int[] w, int W, int n) {
        if (n == 0 || W == 0) return 0;
        if (W < w[n - 1]) return knapsack01(v, w, W, n - 1);
        return Math.max(v[n - 1] + knapsack01(v, w, W - w[n - 1], n - 1), knapsack01(v, w, W, n - 1));
    }

    int knapsack01dp(int[] v, int[] w, int W, int n) {
        int[][] dp = new int[W + 1][n + 1];

        for (int i = 1; i <= W; i++) {
            for (int j = 1; j <= n; j++) {
                if (i < w[j]) {
                    dp[i][j] = dp[i][j - 1];
                }
                else {
                    dp[i][j] = Math.max(v[j - 1] + dp[i - w[j]][j - 1], dp[i][j - 1]);
                }
            }
        }
        return dp[W][n];
    }
}
