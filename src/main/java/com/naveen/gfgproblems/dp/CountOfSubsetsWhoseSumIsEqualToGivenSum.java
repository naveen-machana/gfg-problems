package com.naveen.gfgproblems.dp;

// count subsets whose sum is equal to given sum
// include element and exclude element logic
public class CountOfSubsetsWhoseSumIsEqualToGivenSum {
    int subsetsum(int[] a, int n, int sum) {
        if (n == 0)
            return sum == 0 ? 1 : 0;

        return subsetsum(a, n - 1, sum - a[n - 1])
                + subsetsum(a, n - 1, sum);
    }

    int subsetsumdp(int[] a, int n, int sum) {
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
