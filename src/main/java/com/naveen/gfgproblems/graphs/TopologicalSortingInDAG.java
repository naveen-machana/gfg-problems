package com.naveen.gfgproblems.graphs;

import java.util.*;

// topological sorting in directed acyclic graph
// Kahn's algorithm
public class TopologicalSortingInDAG {

    List<Integer> sort(List<List<Integer>> g, int n) {
        int[] indegree = new int[n];
        for (int i = 0; i < g.size(); i++) {
            for (Integer adj : g.get(i)) {
                indegree[adj]++;
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

            for (int adj : g.get(e)) {
                indegree[adj]--;
                if (indegree[adj] == 0) {
                    pq.offer(adj);
                }
            }
        }

        return res;
    }
}
