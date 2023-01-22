package com.naveen.gfgproblems.dp;

// A frog jumps either 1, 2, or 3 steps to go to the top. In how many ways can it reach the top.
public class CountHops {
    static long countWays(int n)
    {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;

        long a = 1, b = 2, c = 4;

        for (int i = 4; i <= n; i++) {
            long temp = (a + b + c) % 1000000007;
            a = b;
            b = c;
            c = temp;
        }

        return c;
    }
}
