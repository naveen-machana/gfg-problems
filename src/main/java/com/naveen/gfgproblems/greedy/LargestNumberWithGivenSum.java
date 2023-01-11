package com.naveen.gfgproblems.greedy;

// https://www.geeksforgeeks.org/find-the-largest-number-with-given-number-of-digits-and-sum-of-digits/

public class LargestNumberWithGivenSum {
    static String largestNumber(int n, int sum)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 9; j >= 0; j--) {
                if (sum - j >= 0) {
                    sb.append(j);
                    sum -= j;
                    break;
                }
            }
        }

        return sum > 0 ? "-1" : sb.toString();
    }
}
