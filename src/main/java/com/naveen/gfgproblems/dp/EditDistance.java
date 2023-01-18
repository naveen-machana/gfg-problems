package com.naveen.gfgproblems.dp;

// minimum number of operations required to convert s1 into s2
// operations allowed are insert, delete, replace
public class EditDistance {

    // cat, cut
    // ca, cu --> cau, c  insert
    // ca, cu --> ca, ca  replace
    // ca, cu --> c, cu   delete

    int minoperations(char[] s1, char[] s2, int n, int m) {
        if (n == 0) return m;
        if (m == 0) return n;

        if (s1[n - 1] == s2[m - 1]) return minoperations(s1, s2, n - 1, m - 1);

        return 1 + Math.min(minoperations(s1, s2, n - 1, m - 1),
                    Math.min(minoperations(s1, s2, n, m - 1),
                             minoperations(s1, s2, n - 1, m)));
    }

    int minoperationstab(char[] s1, char[] s2, int n, int m) {
        int[][] tab = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) tab[i][0] = i;
        for (int i = 0; i <= m; i++) tab[0][i] = i;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1[i - 1] == s2[j - 1])
                    tab[i][j] = tab[i - 1][j - 1];
                else {
                    tab[i][j] = 1 + Math.min(tab[i - 1][j - 1], Math.min(tab[i][j - 1], tab[i - 1][j]));
                }
            }
        }
        return tab[n][m];
    }
}
