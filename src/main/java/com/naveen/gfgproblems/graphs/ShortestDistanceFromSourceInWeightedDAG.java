package com.naveen.gfgproblems.graphs;

import java.util.*;

// use topological sorting
// for every vertex in sorted list, process its adjacents and see if we can get a minimum distance
// update accordingly
public class ShortestDistanceFromSourceInWeightedDAG {

    int[] shortestPath(List<List<List<Integer>>> g, int src, int n) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        List<Integer> sorted = sort(g, n);

        for (int i = 0; i < sorted.size(); i++) {
            for (List<Integer> adj : g.get(i)) {
                int weightadj = adj.get(1);
                int adjv = adj.get(0);
                distance[adjv] = Math.min(distance[adjv], distance[i] + weightadj);
            }
        }
        return distance;
    }

    List<Integer> sort(List<List<List<Integer>>> g, int n) {
        int[] indegree = new int[n];
        for (int i = 0; i < g.size(); i++) {
            for (List<Integer> adj : g.get(i)) {
                indegree[adj.get(0)]++;
            }
        }

        Deque<Integer> pq = new ArrayDeque<>();
        for (int i = 0; i < g.size(); i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            Integer e = pq.poll();
            res.add(e);

            for (List<Integer> adj : g.get(e)) {
                indegree[adj.get(0)]--;
                if (indegree[adj.get(0)] == 0) {
                    pq.offer(adj.get(0));
                }
            }
        }

        return res;
    }
}
