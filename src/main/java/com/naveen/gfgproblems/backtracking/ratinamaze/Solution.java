package com.naveen.gfgproblems.backtracking.ratinamaze;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
public class Solution {
    private static final Map<String, int[]> ALLOWED_MOVES = new LinkedHashMap<>();
    static {
        ALLOWED_MOVES.put("D", new int[]{1, 0});
        ALLOWED_MOVES.put("L", new int[]{0, -1});
        ALLOWED_MOVES.put("R", new int[]{0, 1});
        ALLOWED_MOVES.put("U", new int[]{-1, 0});
    }

    public ArrayList<String> findPath(int[][] m, int n) {

        ArrayList<String> result = new ArrayList<>();
        if (m[0][0] == 0) return result;

        boolean[][] visited = new boolean[n][n];

        visited[0][0] = true;
        findPath(m, visited, result, "", 0, 0, n);
        return result;
    }

    boolean isSafe(int i, int j, int n, boolean[][] visited, int[][] grid) {
        if (i < 0 || i >= n || j < 0 || j >= n) return false;
        if (grid[i][j] == 0) return false;
        if (visited[i][j]) return false;
        return true;
    }

    void findPath(int[][] m, boolean[][] visited, List<String> result, String path, int i, int j, int n) {
        if (i == n -1 && j == n - 1) {
            result.add(path);
            return;
        }

        for (Map.Entry<String, int[]> move : ALLOWED_MOVES.entrySet()) {
            int[] relativePos = move.getValue();
            int nexti = i + relativePos[0];
            int nextj = j + relativePos[1];

            if (isSafe(nexti, nextj, n, visited, m)) {
                visited[nexti][nextj] = true;
                findPath(m, visited, result, path + move.getKey(), nexti, nextj, n);
                visited[nexti][nextj] = false;
            }
        }
    }
}
