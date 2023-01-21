package com.naveen.gfgproblems.dp;

// eg 1: geek -> 2 cuts are required to g, ee, k substrings which are palindromes
// eg 2: abbac -> 1 cut => abba, c
// eg 3: abcde -> 4 cuts => a, b, c, d, e
public class MinimumCutsRequiredToMakePalindromeSubstrings {
    public static void main(String[] args) {

    }

    int mincuts(String a, int n) {
        if (n == 1) return 0;
        if (isPalindrome(a)) return 0;

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int subres = 1 + mincuts(a.substring(0, i), i) + mincuts(a.substring(i), n - i);
            res = Math.min(res, subres);
        }
        return res;
    }

    boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int st = 0, end = s.length() - 1;
        while (st < end) {
            if (chars[st] == chars[end]) {
                st++;
                end--;
            }
            else return false;
        }
        return true;
    }
}
