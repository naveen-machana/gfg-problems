package com.naveen.gfgproblems.backtracking.kknightsonchessboard;

// number of ways to place 2 black and white knights on chess board
public class BlackAndWhiteKnightOnChessBoard {
    private static final int MOD = 1000000007;

    static long numOfWays(int n, int m) {
        int[][] grid = new int[n][m];

        int mn = (m * n) % MOD;

        Result result = new Result();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = 1;

                int count = 0;
                for (int[] move : allowedMoves) {
                    int x = i + move[0];
                    int y = j + move[1];
                    if (isValid(x, y, n, m)) {
                        count++;
                    }
                }

                grid[i][j] = 0;

                result.incrementBy(mn - count - 1);
            }
        }

        return result.count;
    }

    static int[][] allowedMoves = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1},
            {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    static boolean isValid(int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n) return false;
        return true;
    }

    static class Result {
        int count;

        void incrementBy(int incr) {
            count = (count + incr) % 1000000007;
        }

    }
}
