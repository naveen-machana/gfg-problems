package com.naveen.gfgproblems.dp;

// minimum number of drops required to findout the threshold floor where egg starts breaking
public class EggDrop {

    public static void main(String[] args) {
        System.out.println(mindropsdp(3, 16));
    }
    int mindrops(int e, int f) {
        if (e == 1) return f;
        if (f <= 1) return f;

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= f; i++) {
            res = Math.min(res, 1 + Math.max(mindrops(e - 1, i - 1), mindrops(e, f - i)));
        }

        return res;
    }

    static int mindropsdp(int e, int f) {
        int[][] dp = new int[e + 1][f + 1];

        for (int i = 1; i <= f; i++) dp[1][i] = i;
        for (int i = 1; i <= e; i++) dp[i][1] = 1;

        for (int i = 2; i <= e; i++) {
            for (int j = 2; j <= f; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = 1; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]));
                }
            }
        }

        return dp[e][f];
    }
}
