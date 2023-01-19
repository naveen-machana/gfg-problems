package com.naveen.gfgproblems.dp;

// given an array where every point represents maximum number of jumps that can be made from that position
// find minimum number of jumps to reach the end of the array
// [3, 4, 2, 1, 2, 1] ans: 2
// [4, 1, 5, 3, 1, 3, 2, 1, 8] ans: 3
public class MinimumJumps {

    int minjumps(int[] a, int i, int n) {
        if (i >= n - 1) return 0;

        int res = Integer.MAX_VALUE;
        for (int j = 1; j <= a[i]; j++) {
            int subres = minjumps(a, i + j, n);
            if (subres != Integer.MAX_VALUE) {
                res = Math.min(subres + 1, res);
            }
        }
        return res;
    }

    // [3, 4, 2, 1, 2, 1]
    //  0, 1, 2, 3, 4, 5
    // for this problem, n - 1 is reachable from index 4, 1 elements
    // recursively findout minimum jumps required to reach index 4 and index 1
    int minjumpsrev(int[] a, int n) {
        if (n == 1) return 0;

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (i + a[i] >= n - 1) {
                int subres = minjumpsrev(a, i + 1); // i + 1 because minjumpsrev need size
                if (subres != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + subres);
                }
            }
        }
        return res;
    }

    int minjumpsdp(int[] a, int n) {
        int[] dp = new int[n];

        for (int i = 1; i < n - 1; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int j = 0; j < i; j++) {
                if (j + a[j] >= i && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }
            }
        }

        return dp[n - 1];
    }

}
