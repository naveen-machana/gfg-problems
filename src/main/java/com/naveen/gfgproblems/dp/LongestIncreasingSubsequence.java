package com.naveen.gfgproblems.dp;

import java.util.Arrays;

// length of the longest increasing subsequence
// variations of LIS
// 1. minimum deletions to make an array sorted
// 2. maximum sum increasing subsequence
//    for eg: [3, 20, 4, 6, 7, 30] here LIS would be having a length of 5, and sum is 50 - 3, 4, 6, 7, 30
//    but maximum sum increasing subsequence would be 3, 20, 30 and sum is 53
// 3. maximum length bitonic subsequence
//    a subsequence which is first increasing and then decreasing
//    for eg: [1, 11, 2, 10, 4, 5, 2, 1]
//    find LIS from left-right, find LIS from right-left
// 4. building bridges
//    [(6,2), (4,3), (2,6), (1,5)]
//    connect city 1 with city 2, crossing not allowed
//    find the maximum no of cities that can be connected while no bridge crossed over other bridge(s).
//    solution: sort the list according to the first value in ascending order.
//    If there is a clash, sort according to the second value in ascending order.
//    find the LIS according the second value after sorting.
// 5. longest chain of pairs
//    [(5,24), (39, 60), (15, 28), (27, 40), (50, 90)]
//    sort the array according the first value
//    find LIS and consider an element in LIS only if secondElement.firstValue > firstElement.secondValue
//    It can also be solved using activity selection problem solution where the list is first sorted according to
//    finish time then elements are picked which dont conflict with previous selected elements.
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] a = {3, 4, 2, 8, 10};
        //int[] a = {4, 10, 6, 5, 8, 11, 2, 20};
        //int[] a = {3, 2, 1};
        //System.out.println(lis(a, a.length));
        System.out.println(lisBSearch(a, a.length));

    }

    static int lis(int[] a, int n) {
        int[] length = new int[n];
        Arrays.fill(length, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] >= a[j] && length[i] < 1 + length[j])
                    length[i] = 1 + length[j];
            }
        }

        return length[n - 1];
    }

    // nlogn - eg1
    // 2
    // 4, 5
    // 4, 5, 8
    // 4, 5, 8, 11
    // 4, 5, 8, 11, 20
    // nlogn - eg2
    // 2
    // 3 4
    // 3 4 8
    // 3 4 8 10

    static int lisBSearch(int[] a, int n) {
        int[] p = new int[n];
        int pl = 0;
        p[pl++] = a[0];

        for (int i = 1; i < n; i++) {
            int pos = ceil(p, pl, a[i]);
            p[pos] = a[i];
            if (pos == pl) pl++;
        }

        return pl;
    }

    static int ceil(int[] a, int n, int x) {
        if (a[n - 1] < x) return n;
        int l = 0, h = n - 1;
        while (l < h) {
            int m = (l + h)/2;
            if (a[m] >= x) h = m;
            else l = m + 1;
        }

        return l;
    }

}
