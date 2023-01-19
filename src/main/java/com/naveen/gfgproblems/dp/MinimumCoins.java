package com.naveen.gfgproblems.dp;

// minimum coins to make a value - greedy approach wont work
// [25, 10, 5] val = 30 ans: 2
// [9, 6, 5, 1] val = 11 ans: 2
// notice the difference between "number of ways to make a sum" and "minimum coins required to make a sum"
public class MinimumCoins {

    int mincoins(int[] a, int n, int v) {
        if (v == 0) return 0;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (a[i] <= v) {
                int subres = mincoins(a, n, v - a[i]);
                if (subres != Integer.MAX_VALUE) {
                    res = Math.min(1 + subres, res);
                }
            }
        }

        return res;
    }

    int mincoinstab(int[] a, int n, int v) {
        int[] tab = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            tab[i] = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (a[j] <= i && tab[i - a[j]] != Integer.MAX_VALUE) {
                    tab[i] = Math.min(tab[i], 1 + tab[i - a[j]]);
                }
            }
        }
        return tab[v];
    }
}
