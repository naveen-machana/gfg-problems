package com.naveen.gfgproblems.dp;

// given an array of values, where each value represents the amount of money present in a house
// Help the thief to find out what houses can be robbed to collect maximum money, under the condition that
// no two consecutive houses can be robbed
public class SticklerThief {
    public int findMaxSum(int a[], int n)
    {
        return maxSum(a, n);
    }

    int maxSum(int[] a, int n) {
        if (n == 0) return 0;
        if (n == 1) return a[n - 1];
        if (n == 2) return Math.max(a[n - 1], a[n - 2]);

        return Math.max(a[n - 1] + maxSum(a, n - 2), maxSum(a, n - 1));
    }

    int maxSumDp(int[] a, int n) {
        int[] dp = new int[n + 1];
        dp[1] = a[0]; dp[2] = Math.max(dp[1], a[1]);

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(a[i - 1] + dp[i - 2], dp[i - 1]);
        }

        return dp[n];
    }
}
