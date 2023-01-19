package com.naveen.gfgproblems.dp;

// n = 5, a = 1, b = 2, c = 3
// maximum cuts that can be made such that length of each cut should be either a or b or c
public class MaximumCuts {

    int maxcuts(int n, int a, int b, int c) {
        if (n == 0) return 0;

        if (n < 0) return -1;

        int res = Math.max(maxcuts(n - a, a, b, c),
                  Math.max(maxcuts(n - b, a, b, c),
                           maxcuts(n - c, a, b, c)));

        if (res != -1) {
            return 1 + res;
        }
        else return res;
    }

    int maxcuts2(int n, int a, int b, int c) {
        if (n == 0) return 0;

        int maxa = -1;
        if (n - a >= 0)
            maxa = maxcuts2(n - a, a, b, c);

        int maxb = -1;
        if (n - b >= 0)
            maxb = maxcuts2(n - b, a, b, c);

        int maxc = -1;
        if (n - c >= 0)
            maxc = maxcuts2(n - c, a, b, c);

        int max = Math.max(maxa, Math.max(maxb, maxc));
        if (max != -1)
            return 1+ max;
        else return max;

    }

    int maxcutstab(int n, int a, int b, int c) {
        int[] tab = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int maxa = i - a >= 0 ? tab[i - a] : -1;
            int maxb = i - b >= 0 ? tab[i - b] : -1;
            int maxc = i - c >= 0 ? tab[i - c] : -1;
            int max = Math.max(maxa, Math.max(maxb, maxc));
            if (max != -1) {
                tab[i] = max + 1;
            }
            else tab[i] = max;
        }

        return tab[n];
    }
}
