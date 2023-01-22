package com.naveen.gfgproblems.graphs;

import java.util.ArrayList;
import java.util.List;

// cycle detection in a directed graph
// if there is a back edge, then we say that there is cycle in graph
public class CycleDetectionDirectedGraph {
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
        System.out.println(detectCycle(g, g.size()));
    }

    private static void addEdge(List<List<Integer>> g, int a, int b) {
        g.get(a).add(b);
        g.get(b).add(a);
    }

    private static boolean detectCycle(List<List<Integer>> g, int n) {
        boolean[] visited = new boolean[n];
        boolean[] recSt = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                boolean res = isThereACycle(g, i, visited, recSt);
                if (res) return true;
            }
        }

        return false;
    }

    private static boolean isThereACycle(List<List<Integer>> g, int v, boolean[] visited, boolean[] recSt) {
        visited[v] = true;
        recSt[v] = true;

        for (Integer next : g.get(v)) {
            if (!visited[next] && isThereACycle(g, next, visited, recSt))
                return true;
            else if (recSt[next])
                return true;
        }
        recSt[v] = false;
        return false;
    }
}
