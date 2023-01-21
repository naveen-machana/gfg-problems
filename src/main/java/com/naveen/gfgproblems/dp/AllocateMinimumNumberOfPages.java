package com.naveen.gfgproblems.dp;

// given an array of values, where each value represents the number of pages within a book.
// given a value k - the number of students
// minimize the number of page read by a student with the below constraints
// 1. student can only read contiguous books
// 2. If a student is assigned a book, he has to read all the pages of the book, cannot read a partial book
// 3. allocation has to assign books to given students, such that maximum number of pages read by any student should be minimized
public class AllocateMinimumNumberOfPages {

    int allocate(int[] a, int n, int k) {
        if (k == 1) return sum(a, 0, n);
        if (n == 1) return a[0];

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.min(res, Math.max(allocate(a, i, k - 1), sum(a, i, n)));
        }
        return res;
    }

    int sum(int[] a, int st, int n) {
        int sum = 0;
        for (int i = st; i < n; i++) sum += a[i];
        return sum;
    }

    int allocatedp(int[] a, int n, int k) {
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 0, sum = 0; i < n; i++) {
            sum += a[i];
            dp[1][i] = sum;
        }

        for (int i = 1; i <= k; i++) dp[i][1] = a[0];

        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                for (int p = 1; p < j; p++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][p], sum(a, p, j)));
                }
            }
        }

        return dp[k][n];
    }
}
