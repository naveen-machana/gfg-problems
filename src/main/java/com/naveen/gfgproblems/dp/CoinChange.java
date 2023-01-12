package com.naveen.gfgproblems.dp;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        coinchange(new int[]{1, 2, 3}, 3, 4);
    }

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
