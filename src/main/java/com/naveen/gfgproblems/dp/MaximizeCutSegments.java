package com.naveen.gfgproblems.dp;

// maximize the number of cuts made to make a sum n where each cut should be of length x, y or z.
// its same as coin change problem where minimum coins are used to make the given sum.

public class MaximizeCutSegments {

    public int maximizeCuts(int n, int x, int y, int z) {
        int res = maximize(new int[]{x, y, z}, 3, n);
        return res != Integer.MIN_VALUE ? res : 0;
    }

    int maximize(int[] a, int n, int sum) {
        if (sum == 0) return 0;

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (sum >= a[i]) {
                int subres = maximize(a, n, sum - a[i]);
                if (subres != Integer.MIN_VALUE) {
                    res = Math.max(subres + 1, res);
                }
            }
        }
        return res;
    }

    int maximizedp(int[] a, int n, int sum) {
        int[] dp = new int[sum + 1];

        for (int i = 1; i <= sum; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j : a) {
                if (j <= i && dp[i - j] != Integer.MIN_VALUE) {
                    dp[i] = Math.max(dp[i], 1 + dp[i - j]);
                }
            }
        }

        return dp[sum] != Integer.MIN_VALUE ? dp[sum] : 0;
    }
}
