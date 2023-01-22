package com.naveen.gfgproblems.dp;

// applications of lcs
// 1. diff utility for version control system
// 2. minimum insertion/deletion required to convert s1 into s2
// 3. shortest common supersequence - shortest subsequence which has all chars of s1, s2 =>  s1 + s2 - lcs(s1, s2)
// 4. longest palindromic subsequence of s1 - reverse s1, and find lcs of s1, reverse of s1
// 5. longest repeating subsequence of s1 - lcs(s1, s1) with one change if (s1[m] == s2[n] && m != n) return 1 + lcs(s1, s2, m - 1, n - 1);
// 6. space optimized lcs
// 7. print lcs
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
