package com.naveen.gfgproblems.graphs;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// Kosaraju's Algorithm https://www.geeksforgeeks.org/strongly-connected-components/
// 1. If we do normal DFS, we would reach all the vertices
// 2. If we do DFS from sink, this is inverted, and we would reach individual components only
// 3. Sort the vertices based on their finish time.
// 4. start time is when vertex is first visited, finish time is when there are no more adjacent unvisited vertices.
// 5. reverse the graph. This step is required because, a strongly connected graph remains strongly connected even when reversed
// 5. do a DFS according to finish time of vertices.
public class StronglyConnectedComponents {

    List<List<Integer>> findStronglyConnectedComponents(List<List<Integer>> g, int n) {
        List<Integer> topoSorted = sort(g, n);
        List<List<Integer>> reverse = reverse(g, n);

        List<List<Integer>> connected = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < topoSorted.size(); i++) {
            if (!visited[i]) {
                connected.add(new ArrayList<>());
                dfs(reverse, i, visited, connected.get(connected.size() - 1));
            }
        }
        return connected;
    }

    void dfs(List<List<Integer>> g, int v,boolean[] visited, List<Integer> res) {
        visited[v] = true;
        res.add(v);

        for (Integer adj : g.get(v)) {
            if (!visited[v]) {
                dfs(g, adj, visited, res);
            }
        }
    }

    List<List<Integer>> reverse(List<List<Integer>> g, int n) {
        List<List<Integer>> reverse = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reverse.add(new ArrayList<>());
        }

        for (int i = 0; i < g.size(); i++) {
            for (int j = 0; j < g.get(i).size(); j++) {
                // note this step. we are connecting from j to i
                reverse.get(j).add(i);
            }
        }
        return reverse;
    }

     List<Integer> sort(List<List<Integer>> g, int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(g, i, visited, stack);
            }
        }

        List<Integer> sorted = new ArrayList<>();
        while (!stack.isEmpty()) {
            sorted.add(stack.pop());
        }
        return sorted;
    }

    void dfs(List<List<Integer>> g, int v, boolean[] visited, Deque<Integer> stack) {
        visited[v] = true;

        for (Integer adj : g.get(v)) {
            if (!visited[adj]) {
               dfs(g, adj, visited, stack);
            }
        }
        stack.push(v);
    }
}
