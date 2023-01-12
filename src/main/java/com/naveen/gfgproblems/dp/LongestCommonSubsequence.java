package com.naveen.gfgproblems.dp;

public class LongestCommonSubsequence {
    int lcs(char[] s1, char[] s2, int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (s1[m - 1] == s2[n - 1]) return 1 + lcs(s1, s2, m - 1, n - 1);
        else return Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
    }


    int lcsMem(char[] s1, char[] s2, int m, int n, int[][] dp) {
        if (dp[m][n] != -1) return dp[m][n];
        int res = 0;
        if (m == 0 || n == 0) res = 0;
        else if (s1[m - 1] == s2[n - 1]) res = 1 + lcsMem(s1, s2, m - 1, n - 1, dp);
        else res = Math.max(lcsMem(s1, s2, m - 1, n, dp), lcsMem(s1, s2, m, n - 1, dp));
        dp[m][n] = res;
        return res;
    }

    int lcsTab(char[] s1, char[] s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
