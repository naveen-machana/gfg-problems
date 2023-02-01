package com.naveen.gfgproblems.disjoinsets;

public class UnionFindByRank {
    int n;
    int[] unions;
    int[] rank;
    public UnionFindByRank(int n) {
        this.n = n;
        unions = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            unions[i] = i;
            rank[i] = 0;
        }
    }

    public void union(int a, int b) {
        int repa = find(a);
        int repb = find(b);

        if (repa == repb) return;

        if (rank[repa] < rank[repb]) unions[repa] = repb;
        else if (rank[repa] > rank[repb]) unions[repb] = repa;
        else {
            unions[repa] = repb;
            rank[repb]++;
        }
    }

    public int find(int a) {
        if (unions[a] == a) return a;
        return find(unions[a]);
    }
}
