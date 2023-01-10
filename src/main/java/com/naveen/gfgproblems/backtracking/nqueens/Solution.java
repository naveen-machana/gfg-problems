package com.naveen.gfgproblems.backtracking.nqueens;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// https://practice.geeksforgeeks.org/problems/n-queen-problem0315/1
class Solution{
    private static final int[][] FOUR_CORNERS_RELATIVE_POS = {{-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    ArrayList<ArrayList<Integer>> nQueen(int n) {
        boolean[][] grid = new boolean[n][n];
        Result result = new Result();
        generate(grid, 0, result, n);
        return result.solutions;
    }

    void generate(boolean[][] grid, int rowindex, Result result, int n) {

        if (rowindex == n) {
            addToResult(result, grid, n);
            return;
        }

        for (int cindex = 0; cindex < n; cindex++) {
            if (isSafe(grid, rowindex, cindex, n)) {
                grid[rowindex][cindex] = true;
                generate(grid, rowindex + 1, result, n);
                grid[rowindex][cindex] = false;
            }
        }
    }

    boolean isSafe(boolean[][] grid, int r, int c, int n) {
        for (int i = 0; i < n; i++) {
            if (grid[i][c]) return false;

            for (int[] relativePos : FOUR_CORNERS_RELATIVE_POS) {
                int x = r + relativePos[0] * i;
                int y = c + relativePos[1] * i;

                if (isValid(x, y, n) && isOccupied(grid, x, y)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean isValid(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    boolean isOccupied(boolean[][] grid, int r, int c) {
        return grid[r][c];
    }

    void addToResult(Result result, boolean[][] grid, int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    res.add(j + 1);
                }
            }
        }
        result.solutions.add(res);
    }

    private static class Result {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
    }
}
