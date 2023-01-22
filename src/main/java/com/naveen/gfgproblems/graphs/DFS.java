package com.naveen.gfgproblems.graphs;

import java.util.ArrayList;
import java.util.List;

// applications of DFS
// 1. cycle detection
// 2. topological sorting
// 3. strongly connected components
// 4. solving maze and similar puzzles
// 5. path finding
public class DFS {
    // creating an undirected graph
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
        List<Integer> res = dfs(g);
        System.out.println(res);
    }

    private static void addEdge(List<List<Integer>> g, int a, int b) {
        g.get(a).add(b);
        g.get(b).add(a);
    }

    // possibly disconnected graph, you need to visit all vertices of this graph
    static List<Integer> dfs(List<List<Integer>> g) {
        boolean[] visited = new boolean[g.size()];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < g.size(); i++) {
            if (!visited[i]) {
                dfsHelper(g, i, visited, res);
            }
        }

        return res;
    }

    static void dfsHelper(List<List<Integer>> g, int v, boolean[] visited, List<Integer> res) {
        visited[v] = true;
        res.add(v);

        for (Integer next : g.get(v)) {
            if (!visited[next]) {
                dfsHelper(g, next, visited, res);
            }
        }
    }
}
