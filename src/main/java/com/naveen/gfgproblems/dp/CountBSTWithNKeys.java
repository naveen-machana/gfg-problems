package com.naveen.gfgproblems.dp;

// given n - number of keys, how many different BST we can form with n keys
// if n = 0 => 1 , which is 1 empty BST
// if n = 1 => 1, BST with 1 key
// if n = 2 => 2, one root, one key on either left or right
// if n = 3 => 5
//     1          1           2        3       3
//       2          3       1   3     2     1
//         3      2                  1        2
public class CountBSTWithNKeys {

    int count(int n) {
        if (n <= 2) return n;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += count(i - 1) * count(n - i);
        }
        return res;
    }

    int countdp(int n) {
        if (n <= 1) return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1; dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += (dp[j - 1] * dp[i - j]);
            }
        }

        return dp[n];
    }
}
