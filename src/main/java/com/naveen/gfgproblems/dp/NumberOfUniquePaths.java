package com.naveen.gfgproblems.dp;

public class NumberOfUniquePaths {

    private static final int[][] POSSIBLE_MOVES = {{1, 0}, {0, 1}};

    // backtracking
    int numberOfPaths(boolean[][] grid, int x, int y) {
        if (isTarget(grid, x, y)) return 1;

        int res = 0;
        for (int[] move : POSSIBLE_MOVES) {
            int nx = x + move[0];
            int ny = y + move[1];
            if (isValid(grid, nx, ny)) {
                grid[nx][ny] = true;
                res += numberOfPaths(grid, nx, ny);
                grid[nx][ny] = false;
            }
        }
        return res;
    }

    boolean isTarget(boolean[][] grid, int x, int y) {
        int m = grid.length, n = grid[0].length;
        return m - 1 == x && n - 1 == y;
    }

    boolean isValid(boolean[][] grid, int x, int y) {
        int m = grid.length, n = grid[0].length;
        return x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == false;
    }

    int numPaths(int m, int n) {
        if (m == 1 || n == 1) return 1;

        return numPaths(m - 1, n) + numPaths(m, n - 1);
    }

    int numpathsdp(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) dp[i][1] = 1;
        for (int i = 1; i <= n; i++) dp[1][i] = 1;

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }
}
