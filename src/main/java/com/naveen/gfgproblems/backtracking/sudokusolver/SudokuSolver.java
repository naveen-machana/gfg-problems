package com.naveen.gfgproblems.backtracking.sudokusolver;

public class SudokuSolver {
    static boolean SolveSudoku(int grid[][])
    {
        int m = grid.length;
        return solve(grid, 0, 0, m);
    }

    static void printGrid (int grid[][])
    {
        int m = grid.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
    }

    static boolean solve(int[][] grid, int r, int c, int m) {
        if (r == m && c == 0) return true;

        if (grid[r][c] != 0) {
            int[] nextpos = next(r, c, m);
            return solve(grid, nextpos[0], nextpos[1], m);
        }
        else {
            for (int i = 1; i <= 9; i++) {
                if (isSafe(grid, r, c, i, m)) {
                    grid[r][c] = i;
                    int[] nextpos = next(r, c, m);
                    if (solve(grid, nextpos[0], nextpos[1], m)) {
                        return true;
                    }
                    else grid[r][c] = 0;
                }
            }
        }
        return false;
    }

    static boolean isSafe(int[][] a, int r, int c, int cand, int m) {
        int sgsize = (int)Math.sqrt(m);
        int boxstr = (r/sgsize) * sgsize;
        int boxstc = (c/sgsize) * sgsize;

        for (int i = boxstr; i < boxstr + sgsize; i++) {
            for (int j = boxstc; j < boxstc + sgsize; j++) {
                if (a[i][j] == cand) {
                    return false;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (a[i][c] == cand) return false;
            if (a[r][i] == cand) return false;
        }

        return true;
    }

    static int[] next(int r, int c, int m) {
        int nextc = (c + 1) % m;
        int nextr = nextc == 0 ? r + 1 : r;
        return new int[]{nextr, nextc};
    }
}
