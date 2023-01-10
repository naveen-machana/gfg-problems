package com.naveen.gfgproblems.backtracking.uniquesubsets;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.geeksforgeeks.org/find-distinct-subsets-given-set/
public class Solution {
    public static void main(String[] args) {
        int[] a = {2,1,2};
        System.out.println(AllSubsets(a, a.length));
    }

    public static ArrayList <ArrayList <Integer>> AllSubsets(int a[], int n)
    {
        Arrays.sort(a);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        generate(a, 0, n, new ArrayList<>(), result);
        return result;
    }

    private static void generate(int[] a, int index, int n, ArrayList<Integer> working, ArrayList<ArrayList<Integer>> result) {

        if (index >= n) return;


        for (int i = index; i < n; ) {
            working.add(a[i]);
            result.add(new ArrayList<>(working));
            generate(a, i + 1, n, working, result);
            int j = i + 1;
            while (j < n && a[j] == a[j - 1]) j++;
            i = j;
            working.remove(working.size() - 1);
        }
    }
}
