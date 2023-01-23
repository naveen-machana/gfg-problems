package com.naveen.gfgproblems.graphs;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// Dijkstras shortest path algorithm in a weighted undirected connected graph from source
// similar to Prims algorithm
// 1. This algorithm does not work for negative weights
// 2. Suppose if every edge weight has been increased by fixed value, does the shortest path change from source?
//    Yes. need to recalculate shortest path again.
public class DijkstrasShortestPathAlgorithm {

    int[] shortestPathFromSource(List<List<List<Integer>>> g, int n, int source) {
        int[] distance = new int[n];
        boolean[] finalized = new boolean[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(source, 0));
        finalized[source] = true;

        while(!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (finalized[cur.v]) continue;

            finalized[cur.v] = true;
            for (List<Integer> adj : g.get(cur.v)) {
                int w = adj.get(1);
                int v = adj.get(0);
                if (!finalized[v]) {
                    distance[v] = Math.min(distance[v], distance[cur.v] + w);
                    // note this below step, here weight is distance[v]. not the actual w
                    pq.offer(new Pair(v, distance[v]));
                }
            }
        }
        return distance;
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
