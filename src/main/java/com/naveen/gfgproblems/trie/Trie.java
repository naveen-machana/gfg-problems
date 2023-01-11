package com.naveen.gfgproblems.trie;

public class Trie {
    final static int ALPHABET_SIZE = 26;
    private static class TrieNode {
        TrieNode[] childs = new TrieNode[ALPHABET_SIZE];
        boolean isEnd;
    }

    void insert(TrieNode root, String key) {
        TrieNode cur = root;
        for (char c : key.toCharArray()) {
            if (cur.childs[c - 'a'] == null) cur.childs[c - 'a'] = new TrieNode();
            cur = cur.childs[c - 'a'];
        }
        cur.isEnd = true;
    }

    boolean search(TrieNode root, String key) {
        TrieNode cur = root;
        for (char c : key.toCharArray()) {
            if (cur.childs[c - 'a'] == null) return false;
            cur = cur.childs[c - 'a'];
        }
        return cur.isEnd;
    }

    TrieNode delete(TrieNode root, String key, int index, int n) {
        if (root == null) return root;

        if (index == n) {
            root.isEnd = false;
            root = isEmpty(root) ? null : root;
            return root;
        }

        int tindex = key.charAt(index) - 'a';

        root.childs[tindex] = delete(root.childs[tindex], key, index + 1, n);
        return (isEmpty(root) && !root.isEnd) ? null : root;
    }

    boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.childs) {
            if (child != null) return false;
        }
        return true;
    }
}
