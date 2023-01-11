package com.naveen.gfgproblems.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

// Given a set of N jobs where each jobi has a deadline and profit associated with it.
//Each job takes 1 unit of time to complete and only one job can be scheduled at a time.
// We earn the profit associated with job if and only if the job is completed by its deadline.
//Find the number of jobs done and the maximum profit.
// https://www.geeksforgeeks.org/job-sequencing-problem/
public class JobSequencing {

    int[] JobScheduling(Job a[], int n)
    {
        PriorityQueue<Job> pq = new PriorityQueue<>((j1, j2) -> j2.profit - j1.profit);
        int maxDeadline = -1;
        for (int i = 0; i < n; i++) {
            pq.offer(a[i]);
            maxDeadline = Math.max(maxDeadline, a[i].deadline);
        }

        int profit = 0;
        boolean[] available = new boolean[maxDeadline];
        Arrays.fill(available, true);

        int count = 0;
        while (!pq.isEmpty() && count < maxDeadline) {
            Job cur = pq.poll();
            for (int i = cur.deadline; i > 0; i--) {
                if (available[i - 1]) {
                    available[i - 1] = false;
                    profit += cur.profit;
                    count++;
                    break;
                }
            }
        }

        return new int[]{count, profit};
    }

    private static class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
}
