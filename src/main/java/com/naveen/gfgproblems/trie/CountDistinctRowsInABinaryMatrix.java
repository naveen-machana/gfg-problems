package com.naveen.gfgproblems.trie;

public class CountDistinctRowsInABinaryMatrix {

    public static void main(String[] args) {
        //int[][] matrix = {{1, 0, 0}, {1, 1, 1}, {1, 0, 0}, {1, 1, 1}};
        //int[][] matrix = {{1, 1, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {0, 1, 1, 1}};
        int[][] matrix = {{1, 1, 0, 0}, {1, 1, 0, 0},{1, 1, 0, 0},{1, 1, 0, 0}};
        TrieNode root = insert(matrix, 4);
        System.out.println(count(root));
    }
    private static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    public static TrieNode insert(int[][] mat, int n) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < n; i++) {
            TrieNode cur = root;
            for (int j = 0; j < n; j++) {
                if (cur.children[mat[i][j]] == null) {
                    cur.children[mat[i][j]] = new TrieNode();
                }
                cur = cur.children[mat[i][j]];
            }
        }

        return root;
    }

    public static int count(TrieNode root) {
        if (root == null) return 0;
        if (isEmpty(root)) return 1;

        int count = 0;
        for (TrieNode child : root.children) {
            count += count(child);
        }
        return count;
    }

    private static boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) return false;
        }
        return true;
    }

}
