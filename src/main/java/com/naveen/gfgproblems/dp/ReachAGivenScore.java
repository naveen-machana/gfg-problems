package com.naveen.gfgproblems.dp;

// Consider a game where a player can score 3 or 5 or 10 points in a move.
// Given a total score n, find the number of distinct combinations to reach the given score
public class ReachAGivenScore {
    int count(int n) {
        return count(new int[]{3, 5, 10}, 3, n);
    }

    int count(int[] a, int n, int sum) {
        if (sum == 0) return 1;
        if (n == 0) return 0;
        if (a[n - 1] > sum) return count(a, n - 1, sum);
        return count(a, n, sum - a[n - 1]) + count(a, n - 1, sum);
    }

    int countdp(int[] a, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (a[i - 1] <= j)
                    dp[i][j] += dp[i][j - a[i - 1]];
            }
        }

        return dp[n][sum];
    }
}
