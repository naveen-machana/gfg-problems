package com.naveen.gfgproblems.dp;

import java.util.Arrays;

// length of the longest increasing subsequence
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] a = {3, 4, 2, 8, 10};
        //int[] a = {4, 10, 6, 5, 8, 11, 2, 20};
        //int[] a = {3, 2, 1};
        //System.out.println(lis(a, a.length));
        System.out.println(lisBSearch(a, a.length));

    }

    static int lis(int[] a, int n) {
        int[] length = new int[n];
        Arrays.fill(length, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] >= a[j] && length[i] < 1 + length[j])
                    length[i] = 1 + length[j];
            }
        }

        return length[n - 1];
    }

    // nlogn - eg1
    // 2
    // 4, 5
    // 4, 5, 8
    // 4, 5, 8, 11
    // 4, 5, 8, 11, 20
    // nlogn - eg2
    // 2
    // 3 4
    // 3 4 8
    // 3 4 8 10

    static int lisBSearch(int[] a, int n) {
        int[] p = new int[n];
        int pl = 0;
        p[pl++] = a[0];

        for (int i = 1; i < n; i++) {
            int pos = ceil(p, pl, a[i]);
            p[pos] = a[i];
            if (pos == pl) pl++;
        }

        return pl;
    }

    static int ceil(int[] a, int n, int x) {
        if (a[n - 1] < x) return n;
        int l = 0, h = n - 1;
        while (l < h) {
            int m = (l + h)/2;
            if (a[m] >= x) h = m;
            else l = m + 1;
        }

        return l;
    }

}
