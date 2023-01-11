package com.naveen.gfgproblems.greedy;

import java.util.PriorityQueue;

// Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Greedy/problem/fractional-knapsack-1587115620
public class FractionalKnapsack {
    double fractionalKnapsack(int W, Item a[], int n)
    {
        PriorityQueue<Item> pq = new PriorityQueue<>((o1, o2) -> o2.value * o1.weight - o1.value * o2.weight);

        for (int i = 0; i < n; i++) {
            pq.add(a[i]);
        }

        double res = 0;

        while (W > 0 && !pq.isEmpty()) {
            Item cur = pq.poll();
            if (W >= cur.weight) {
                res += cur.value;
                W -= cur.weight;
            }
            else {
                res += (((double)cur.value) / ((double)cur.weight)) * W;
                W = 0;
            }
        }

        return res;
    }

    private static class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }
}
