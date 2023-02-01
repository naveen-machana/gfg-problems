package com.naveen.gfgproblems.disjoinsets;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KruskalMinimumSpanningTree {
    private static class Edge {
        int src, des, wt;
        public Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }
    static long kruskalDSU(ArrayList<Edge> adj, int n, int m)
    {
        PriorityQueue<Edge> pq = new PriorityQueue<>((one, two) -> one.wt - two.wt);
        for (Edge e : adj) pq.offer(e);
        UnionFind ds = new UnionFind(n);

        int res = 0;
        // NOTE: also make sure if the number of connected vertices added are lessthan or equals to n
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (ds.areConnected(e.src, e.des)) continue;
            else {
                ds.union(e.src, e.des);
                res += e.wt;
            }
        }

        return res;
    }

    private static class UnionFind {
        int n;
        int[] unions;
        public UnionFind(int n) {
            this.n = n + 1;
            this.unions = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                unions[i] = i;
            }
        }
        public void union(int a, int b) {
            int repa = find(a);
            int repb = find(b);
            unions[repa] = repb;
        }
        public int find(int a) {
            if (unions[a] == a) return a;
            unions[a] = find(unions[a]);
            return unions[a];
        }
        public boolean areConnected(int a, int b) {
            int repa = find(a);
            int repb = find(b);
            return repa == repb;
        }
    }
}
