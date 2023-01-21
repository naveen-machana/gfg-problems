package com.naveen.gfgproblems.dp;

// check if set can be divided into 2 subsets such that sum of both subsets is equal
public class EqualSumPartition {
    public boolean findPartition(int[] a, int n)
    {
        int totalSum = 0;
        for (int i = 0; i < n; i++) totalSum += a[i];

        if ((totalSum & 1) != 0) return false;

        return subsetsum(a, n, totalSum/2);
    }

    boolean subsetsum(int[] a, int n, int sum) {
        if (sum == 0) return true;
        if (n == 0) return false;

        if (a[n - 1] > sum) return subsetsum(a, n - 1, sum);
        return subsetsum(a, n - 1, sum - a[n - 1]) || subsetsum(a, n - 1, sum);
    }

    boolean subsetsumdp(int[] a, int n, int sum) {
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (a[i - 1] <= j)
                    dp[i][j] |= dp[i - 1][j - a[i - 1]];
            }
        }

        return dp[n][sum];
    }
}
