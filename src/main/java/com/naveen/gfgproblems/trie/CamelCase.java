package com.naveen.gfgproblems.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Trie/problem/camel-case04234120
public class CamelCase {
    public static void main(String[] args) {
        String[] dict = {"Hi", "Hello", "HelloWorld", "HiTech", "HiGeek", "HiTechWorld", "HiTechCity", "HiTechLab"};
        findAllWords(dict, "HT");
    }
    static void findAllWords(String[] dict, String pattern)
    {
        TrieNode root = new TrieNode();
        for (String word : dict) {
            insert(root, word);
        }

        search(root, pattern);
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        Set<String> words = new TreeSet<>();
        boolean isEndOfWord = false;
    }

    public static void search(TrieNode root, String pattern) {
        TrieNode cur = root;
        char[] patchars = pattern.toCharArray();
        for (char c : patchars) {
            int index = c - 'A';
            if (cur.children[index] == null) {
                System.out.println("No match found");
                return;
            }
            cur = cur.children[index];
        }
        printWords(cur);
    }

    private static void printWords(TrieNode root) {
        if (root == null) return;

        if (isEmpty(root) || root.isEndOfWord) {
            for (String word : root.words) {
                System.out.print(word + " ");
            }
        }

        for (TrieNode child : root.children) {
            printWords(child);
        }
    }

    private static boolean isEmpty(TrieNode root) {
        for (TrieNode child : root.children) {
            if (child != null) return false;
        }
        return true;
    }

    public static void insert(TrieNode root, String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (char c : chars) {
            if (Character.isLowerCase(c)) continue;
            int index = c - 'A';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.words.add(word);
        cur.isEndOfWord = true;
    }
}
