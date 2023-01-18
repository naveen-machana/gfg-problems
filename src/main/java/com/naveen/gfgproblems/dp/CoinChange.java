package com.naveen.gfgproblems.dp;

import java.util.Arrays;
// we have infinite supply of coins
public class CoinChange {

    private static class BacktrackingSolution {
        static int coinchange(int[] coins, int n, int sum) {
            Arrays.sort(coins);
            int res = ways(coins, n, sum, "", 0);
            System.out.println(res);
            return res;
        }

        // backtracking solution without duplicates
        static int ways(int[] coins, int n, int sum, String path, int j) {
            if (sum == 0) {
                System.out.println(path);
                return 1;
            }

            int res = 0, count = 0;
            for (int i = j; i < n; i++) {
                if (sum - coins[i] >= 0) {
                    count += ways(coins, n, sum - coins[i], path + ", "+ coins[i], i);
                    res = Math.max(res, count);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int res = coinchange(new int[]{1, 2, 3}, 3, 4);
        System.out.println(res);

        res = coinchangetab(new int[]{1, 2, 3}, 3, 4);
        System.out.println(res);
    }

    static int coinchange(int[] coins, int n, int sum) {
        if (sum == 0) {
            return 1;
        }

        if (n <= 0) return 0;

        if (sum - coins[n - 1] < 0)
            return coinchange(coins, n - 1, sum);

        return coinchange(coins, n, sum - coins[n - 1]) + coinchange(coins, n - 1, sum);
    }

    static int coinchangetab(int[] coins, int n, int sum) {
        int[][] ways = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) ways[i][0] = 1;
        ways[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                ways[i][j] = ways[i - 1][j];
                if (coins[i - 1] <= j)
                    ways[i][j] += ways[i][j - coins[i - 1]];
            }
        }

        return ways[n][sum];
    }

}
