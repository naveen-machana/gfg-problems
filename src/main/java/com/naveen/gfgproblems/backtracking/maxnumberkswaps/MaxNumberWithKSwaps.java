package com.naveen.gfgproblems.backtracking.maxnumberkswaps;

public class MaxNumberWithKSwaps {
    public static String findMaximumNum(String str, int k)
    {
        Result result = new Result(str);
        char[] chars = str.toCharArray();
        findMax(chars, k, chars.length, 0, result);
        return result.result;
    }

    private static void findMax(char[] chars, int k, int n, int index, Result result) {
        if (k == 0) return;

        for (int i = index; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (chars[j] > chars[i]) {
                    swap(chars, i, j);
                    setGreaterInResult(result, chars);
                    findMax(chars, k - 1, n, index + 1, result);
                    swap(chars, i, j);
                }
            }
        }
    }

    private static void setGreaterInResult(Result result, char[] chars) {
        String temp = new String(chars);
        result.result = result.result.compareTo(temp) >= 0 ? result.result : temp;
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private static class Result {
        String result;
        public Result(String result) {
            this.result = result;
        }
    }
}
