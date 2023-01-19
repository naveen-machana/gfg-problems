package com.naveen.gfgproblems.dp;

public class NumberOfWaysToMakeNWithPositiveIntegers {

    // function to count ways in which n can be
    // expressed as the sum of two or more integers
    int countWays(int n)
    {
        int sum = n;
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (i <= j)
                    dp[i][j] += dp[i][j - i];
            }
        }

        return dp[n][n] - 1;

    }
}
