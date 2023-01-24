package com.naveen.gfgproblems.graphs;

import java.util.List;
import java.util.PriorityQueue;

// Given a weighted undirected connected graph, find MST
// every vertex should be connected in such a way that their combined weight for connections should be minimum
// every vertex should be connected to other vertex may be through some intermediate vertex
// starting point. It doesn’t matter which one because MST is unique and no matter where you start, you are going to end up with the same tree.
public class MinimumSpanningTreePrimsAlgorithm {

    public int minimumSpanningTree(List<List<List<Integer>>> g, int n) {
        boolean[] visited = new boolean[n];
        int res = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0, 0));
        visited[0] = true;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            if (visited[cur.v]) continue;
            visited[cur.v] = true;
            res += cur.w;

            for (List<Integer> adj : g.get(cur.v)) {
                if (!visited[adj.get(0)]) {
                    pq.offer(new Pair(adj.get(0), adj.get(1)));
                }
            }

        }

        return res;
    }

    private static class Pair implements Comparable<Pair> {
        int v, w;
        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Pair o) {
            return w - o.w;
        }
    }
}
