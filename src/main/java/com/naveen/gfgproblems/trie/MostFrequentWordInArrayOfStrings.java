package com.naveen.gfgproblems.trie;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Trie/problem/most-frequent-word-in-an-array-of-strings3528
// Your task is to find the most frequent word in the array. If multiple words have same frequency, then print the word whose first occurence occurs last in the array as compared to the other strings with same frequency.
public class MostFrequentWordInArrayOfStrings {
    public static void main(String[] args) {
        String[] words = {"xejdcj", "xejdcj", "lvjpb", "tmyuiu", "lvjpb", "tmyuiu", "ovoba", "lvjpb", "lvjpb", "fqhyu", "fqhyu", "tmyuiu", "xejdcj", "tmyuiu", "fqhyu", "ovoba", "xejdcj"};
        MostFrequentWordInArrayOfStrings sol = new MostFrequentWordInArrayOfStrings();
        String res = sol.mostFrequentWord(words, words.length);
        System.out.println(res);
    }

    public String mostFrequentWord(String words[],int n)
    {
        Node root = new Node();
        for (int i = 0; i < n; i++) {
            insert(root, words[i], i);
        }

        Result result = new Result();
        search(root, result, "");
        return result.maxString;
    }

    private void search(Node root, Result result, String current) {
        if (root == null) return;

        if (root.isEndOfWord) {
            setMax(result, root, current);
        }

        for (Node child : root.children) {
            String temp = child == null ? current : current + child.c;
            search(child, result, temp);
        }
    }

    private void setMax(Result result, Node root, String current) {
        if (root.count > result.maxCount) {
            result.maxString = current;
            result.maxCount = root.count;
            result.firstIndex = root.firstIndex;
        }

        else if (root.count == result.maxCount && root.firstIndex > result.firstIndex) {
            result.maxString = current;
            result.maxCount = root.count;
            result.firstIndex = root.firstIndex;
        }
    }

    private void insert(Node root, String word, int firstIndex) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Node();
            }
            cur = cur.children[index];
            cur.c = c;

        }
        cur.isEndOfWord = true;
        cur.firstIndex = Math.min(firstIndex, cur.firstIndex);
        cur.count++;
    }

    private static class Node {
        Node[] children = new Node[26];
        char c;
        boolean isEndOfWord;
        int count;
        int firstIndex = Integer.MAX_VALUE;
    }

    private static class Result {
        int maxCount;
        int firstIndex;
        String maxString = "";
    }
}
