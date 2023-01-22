package com.naveen.gfgproblems.graphs;

import java.util.ArrayList;
import java.util.List;

// cycle detection in undirected graph
public class CycleDetection {
    public static void main(String[] args) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            g.add(new ArrayList<Integer>());
        }
        addEdge(g, 0, 1);
        addEdge(g, 0, 2);
        addEdge(g, 0, 5);
        addEdge(g, 1, 3);
        addEdge(g, 2, 4);
        addEdge(g, 4, 5);
        addEdge(g, 3, 5);
        System.out.println(isThereACycle(g, g.size()));
    }

    private static void addEdge(List<List<Integer>> g, int a, int b) {
        g.get(a).add(b);
        g.get(b).add(a);
    }

    private static boolean isThereACycle(List<List<Integer>> g, int n) {
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                boolean isCycle = dfs(g, visited, i, -1);
                if (isCycle) return true;
            }
        }

        return false;
    }

    private static boolean dfs(List<List<Integer>> g, boolean[] visited, int v, int p) {
        visited[v] = true;

        for (Integer next : g.get(v)) {
            if (!visited[next]) {
                visited[next] = true;
                boolean res = dfs(g, visited, next, v);
                if (res) return true;
            }
            else if (next != p) {
                return true;
            }
        }

        return false;
    }
}
