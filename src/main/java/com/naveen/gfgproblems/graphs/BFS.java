package com.naveen.gfgproblems.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// applications of vfs
// 1. shortest path in an unweighted graph
// 2. crawlers in search engine
// 3. peer to peer networks (bittorrents)
// 4. social networking search
// 5. in garbage collection
// 6. cycle detection
// 7. broadcasting
// 8. Dijkstra's algorithm
public class BFS {
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
        List<Integer> res = bfs(g);
        System.out.println(res);
    }

    private static void addEdge(List<List<Integer>> g, int a, int b) {
        g.get(a).add(b);
        g.get(b).add(a);
    }

    // possibly disconnected graph, you need to visit all vertices of this graph
    static List<Integer> bfs(List<List<Integer>> g) {
        boolean[] visited = new boolean[g.size()];

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < g.size(); i++) {
            if (!visited[i]) {
                bfsHelper(g, visited, i, res);
            }
        }
        return res;
    }

    // find all reachable from given source.
    static void bfsHelper(List<List<Integer>> g, boolean[] visited, int v, List<Integer> res) {
        Deque<Integer> q = new ArrayDeque<>();

        visited[v] = true;
        q.offer(v);
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            res.add(cur);
            for (Integer next : g.get(cur)) {
                if (! visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
