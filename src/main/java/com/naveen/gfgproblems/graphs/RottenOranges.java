package com.naveen.gfgproblems.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RottenOranges {

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};
        int res = orangesRotting(grid);
        System.out.println(res);
    }

    private static int orangesRotting(int[][] grid)
    {
        Deque<int[]> curq = new ArrayDeque<>();
        Deque<int[]> next = new ArrayDeque<>();

        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    curq.offer(new int[]{i, j});
                }
            }
        }

        if (curq.isEmpty()) return 0;

        int res = 0;

        while (!curq.isEmpty()) {
            int[] cur = curq.poll();
            next.addAll(adjacent(cur, m, n, grid));

            if (curq.isEmpty() && !next.isEmpty()) {
                res++;
                Deque<int[]> temp = curq;
                curq = next;
                next = temp;
            }
        }

        return isNotCompletelyRotten(grid, m, n) ? -1 : res;
    }

    private static boolean isNotCompletelyRotten(int[][] grid, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static List<int[]> adjacent(int[] cur, int m, int n, int[][] grid) {
        int[][] possibleMoves = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        List<int[]> validMoves = new ArrayList<>();

        for (int[] move : possibleMoves) {
            int nextx = cur[0] + move[0], nexty = cur[1] + move[1];
            if ( nextx >= 0 && nexty >= 0
                    && nextx < m && nexty < n
                    && grid[nextx][nexty] == 1) {
                grid[nextx][nexty] = 2;
                validMoves.add(new int[]{nextx, nexty});
            }
        }

        return validMoves;
    }
}
