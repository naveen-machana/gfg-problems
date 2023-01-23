package com.naveen.gfgproblems.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TopologicalSortingUsingDFS {

    List<Integer> sort(List<List<Integer>> g, int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(g, i, visited, stack);
            }
        }

        // topological sorting would be attained by popping elements from stack
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    void dfs(List<List<Integer>> g, int v, boolean[] visited, Deque<Integer> stack) {
        visited[v] = true;

        for (Integer adj : g.get(v)) {
            if (!visited[adj]) {
                dfs(g, adj, visited, stack);
            }
        }

        // take a note of this step. This is the only difference from standard dfs
        stack.push(v);
    }
}
