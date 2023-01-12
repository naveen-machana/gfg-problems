package com.naveen.gfgproblems.backtracking.anagrams;

import java.util.Arrays;

public class AnagramGenerator {
    public static void main(String[] args) {
        generate(new char[]{'a', 'b', 'c'}, 0, 3);
    }

    static void generate(char[] str, int i, int n) {
        if (i == n) {
            System.out.println(Arrays.toString(str));
            return;
        }

        for (int j = i; j < n; j++) {
            swap(str, i, j);
            generate(str, i + 1, n);
            swap(str, i, j);
        }
    }

    static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
