package com.naveen.gfgproblems.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Greedy/problem/activity-selection-1587115620
// Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a given day.
// another way of asking it, given n meetings, schedule maximum possible meetings such that there are no conflicts among the schedules

public class ActivitySelection {

    public static int activitySelection(int st[], int end[], int n)
    {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(st[i], end[i]));
        }

        Collections.sort(pairs);

        Pair prev = pairs.get(0);
        int res = 1;

        for (int i = 1; i < n; i++) {
            Pair cur = pairs.get(i);
            if (prev.end < cur.st) {
                res++;
                prev = cur;
            }
        }

        return res;
    }

    private static class Pair implements Comparable<Pair> {
        int st, end;
        public Pair(int st, int end) {
            this.st = st;
            this.end = end;
        }

        public int compareTo(Pair p) {
            return this.end - p.end;
        }
    }
}
