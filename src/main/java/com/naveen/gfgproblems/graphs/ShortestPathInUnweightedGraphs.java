package com.naveen.gfgproblems.graphs;

import java.util.*;

// find shortest distance from source vertex to every other vertex
public class ShortestPathInUnweightedGraphs {
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
        int[] res = shortestpath(g, 0, g.size());
        System.out.println(Arrays.toString(res));
    }

    private static void addEdge(List<List<Integer>> g, int a, int b) {
        g.get(a).add(b);
        g.get(b).add(a);
    }

    private static int[] shortestpath(List<List<Integer>> g, int v, int n) {
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        // initializing with infinite because there could disconnected components within graph, any they might never be
        // reachable from source.
        Arrays.fill(distance, Integer.MAX_VALUE);
        Deque<Integer> q = new ArrayDeque<>();
        visited[v] = true;
        q.offer(v);
        distance[v] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (Integer next : g.get(cur)) {
                if (!visited[next]) {
                    distance[next] = distance[cur] + 1;
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        return distance;
    }
}
