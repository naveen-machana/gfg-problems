package com.naveen.gfgproblems.backtracking.combinationsum;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

// https://www.geeksforgeeks.org/combinational-sum/
public class Solution {
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> ip, int sum)
    {
        Result result = new Result();
        Set<Integer> withoutDuplicates = new TreeSet<>(ip);
        ip = new ArrayList<>(withoutDuplicates);
        combinationSum(ip, sum, 0, new ArrayList<Integer>(), result);
        return result.result;
    }

    private static void combinationSum(ArrayList<Integer> ip, int sum, int index, ArrayList<Integer> working, Result result) {
        if (sum == 0) {
            result.result.add(new ArrayList<Integer>(working));
            return;
        }

        if (sum < 0) return;

        for (int i = index; i < ip.size(); i++) {
            int nextSum = sum - ip.get(i);
            if (nextSum >= 0) {
                working.add(ip.get(i));
                combinationSum(ip, nextSum, i, working, result);
                working.remove(working.size() - 1);
            }
        }
    }
    private static class Result {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    }
}
