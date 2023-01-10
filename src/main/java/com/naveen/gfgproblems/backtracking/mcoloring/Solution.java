package com.naveen.gfgproblems.backtracking.mcoloring;

// https://www.geeksforgeeks.org/m-coloring-problem-backtracking-5/
public class Solution {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] colors = new int[n];

        return color(graph, colors, m, n, 0);
    }

    boolean color(boolean[][] graph, int[] colors, int m, int n, int index) {
        if (index == n) {
            return true;
        }

        for (int i = 1; i <= m; i++) {
            if (isSafe(graph, colors, i, n, index)) {
                colors[index] = i;
                if (color(graph, colors, m, n, index + 1)) return true;
                colors[index] = 0;
            }
        }
        return false;
    }

    boolean isSafe(boolean[][] graph, int[] colors, int toBeUsedColor, int n, int index) {
        for (int j = 0; j < n; j++) {
            if (graph[index][j] && toBeUsedColor == colors[j])
                return false;
        }
        return true;
    }
}
