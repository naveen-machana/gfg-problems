package com.naveen.gfgproblems.graphs;

// in an undirected connected graph
// articulation points are those vertices in a graph, removing them increases the number of connected components
// it is used to find out the vulnerable points in a graph, which means, say if a vertex breaks down, your whole network
// might be disconnected. so finding out the articulation points helps find the vulnerable points and add some more
// edges across the articulation points, so that your graph still remains connected even after the articulation points broke down
// use dfs traversal to find out the articulation points
// 1. dfs tree of root has 2 or more children, then its an articulation point
// 2. discovery time is simply when a vertex is visited during dfs traversal, low time is the "lowest discovery time" vertex
//    reachable from this vertex. consider u -> v, u is an articulation point if u has a child v in dfs whose discovery time
//    is more than or equal to low time. low[v] >= dis[u]
//    u is not the root of the DFS tree and it has a child v such that no vertex in the subtree rooted with v has a
//    back edge to one of the ancestors in DFS tree of u
public class ArticulationPoint {
}
