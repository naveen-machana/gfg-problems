package com.naveen.gfgproblems.disjoinsets;

public class UnionFindWithPathCompression {
    int n;
    int[] unions;
    public UnionFindWithPathCompression(int n) {
        this.n = n;
        unions = new int[n];
        for (int i = 0; i < n; i++) {
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
}
