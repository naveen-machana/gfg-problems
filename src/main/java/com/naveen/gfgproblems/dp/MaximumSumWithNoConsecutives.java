package com.naveen.gfgproblems.dp;

// find the maximum sum such that no two consecutive elements have contributed to the sum
// 8 7 6 10 - ans 18
public class MaximumSumWithNoConsecutives {

    int maxSum(int[] a, int n) {

        if (n == 1) return a[n - 1];
        if (n == 2) return Math.max(a[n - 1], a[n - 2]);

        return Math.max(a[n - 1] + maxSum(a, n - 2), maxSum(a, n - 1));
    }

    int maxSumDp(int[] a, int n) {
        int[] dp = new int[n];

        dp[0] = a[0];
        dp[1] = Math.max(dp[0], a[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(a[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[n];
    }

}

