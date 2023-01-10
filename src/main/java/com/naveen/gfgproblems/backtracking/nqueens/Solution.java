package com.naveen.gfgproblems.backtracking.nqueens;

import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/n-queen-problem0315/1
class Solution{
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

            int[] leftTopDiagonal = {r - i, c - i};
            if (isValid(leftTopDiagonal, n) && isOccupied(grid, leftTopDiagonal)) return false;

            int[] rightBottomDiagonal = {r + i, c + i};
            if (isValid(rightBottomDiagonal, n) && isOccupied(grid, rightBottomDiagonal)) return false;

            int[] rightTopDiagonal = {r - i, c + i};
            if (isValid(rightTopDiagonal, n) && isOccupied(grid, rightTopDiagonal)) return false;

            int[] leftBottomDiagonal = {r + i, c - i};
            if (isValid(leftBottomDiagonal, n) && isOccupied(grid, leftBottomDiagonal)) return false;
        }

        return true;
    }

    boolean isValid(int[] pos, int n) {
        return pos[0] >= 0 && pos[0] < n && pos[1] >= 0 && pos[1] < n;
    }

    boolean isOccupied(boolean[][] grid, int[] pos) {
        return grid[pos[0]][pos[1]];
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
