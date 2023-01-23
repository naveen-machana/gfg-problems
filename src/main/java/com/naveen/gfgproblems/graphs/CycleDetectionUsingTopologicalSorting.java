package com.naveen.gfgproblems.graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

// topological sorting is used when there are no cycles in a graph
// if there is a cycle then sorting would not have visited all the vertices as the in-degree of some vertices
// can never become zero. So number of vertices is not equal to number of visited vertices, then there is a cycle.
public class CycleDetectionUsingTopologicalSorting {
    boolean detectCycle(List<List<Integer>> g, int n) {
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

        int count = 0;
        while (!pq.isEmpty()) {
            Integer e = pq.poll();

            for (int adj : g.get(e)) {
                indegree[adj]--;
                if (indegree[adj] == 0) {
                    pq.offer(adj);
                }
            }
            count++;
        }

        return count != n;
    }
}
