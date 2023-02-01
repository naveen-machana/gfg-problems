package com.naveen.gfgproblems.disjoinsets;

public class UnionFind {
    int n;
    int[] unions;
    public UnionFind(int n) {
        this.n = n;
        unions = new int[n];
        for (int i = 0; i < n; i++)
            unions[i] = i;
    }
    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;
        unions[pb] = pa;
    }
    public int find(int a) {
        if (unions[a] == a)
            return unions[a];
        return find(unions[a]);
    }
}
