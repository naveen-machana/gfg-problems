package com.naveen.gfgproblems.dp;

// minimum number of drops required to findout the threshold floor where egg starts breaking
// for every floor, optimal trials required is calculated by looping through every floor before it (including that floor)
// at every floor there are 2 cases, either egg breaks or it wont
// if egg breaks, then we have to find out where the egg breaks before this floor recursively
// if egg wont break, then we have n - f floors to check, which are after this floor
// adding 1 to result is because, 1 trail has been made
// taking the maximum because egg might break at all floors (otherway of saying it is, egg might break from 1st floor,
// so if we start from say floor 5, we would have tried all floors, like 4,3,2,1.
// taking the minimum because, we have to find out the optimal solution
public class EggDrop {

    public static void main(String[] args) {
        System.out.println(mindropsdp(2, 4));
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
