package com.naveen.gfgproblems.dp;

// find out the maximum subarray sum that we can get where removing atmost one element is allowed
// this is kadane's algorithm
// since removing one element is allowed, we are getting the max sum at each position in both forward and backward direciton
public class MaximumSubarraySumByRemovingAtmostOneElement {

    public static int maxSumSubarray(int a[], int n)
    {
        int[] fw = new int[n];
        int[] bw = new int[n];

        int curmax = a[0], max = a[0];
        fw[0] = a[0];

        for (int i = 1; i < n; i++) {
            curmax = Math.max(curmax + a[i], a[i]);
            fw[i] = curmax;
        }

        bw[n - 1] = curmax = max = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            curmax = Math.max(curmax + a[i], a[i]);
            max = Math.max(max, curmax);
            bw[i] = curmax;
        }

        // max of max, fw & bw is taken
        // this is to ensure if no element is removed, whole array itself is considered as a subarray
        for (int i = 1; i < n - 1; i++) {
            max = Math.max(max, fw[i - 1] + bw[i + 1]);
        }

        return max;
    }
}
