package com.naveen.gfgproblems.greedy.huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {
    static String decodeHuffmanData(Node root, String binaryString)
    {
        java.util.function.Function<Node, Boolean> isLeaf = node -> node.left == null && node.right == null;
        StringBuilder res = new StringBuilder();
        Node temp = root;
        char[] chars = binaryString.toCharArray();
        for (char c : chars) {
            temp = c == '0' ? temp.left : temp.right;
            if (isLeaf.apply(temp)) {
                res.append(temp.c);
                temp = root;
            }
        }

        return res.toString();
    }

    private static class Node implements Comparable<Node> {
        int freq;
        char c;
        Node left, right;
        public Node(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }

        public int compareTo(Node o) {
            return this.freq - o.freq;
        }
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'd', 'b', 'e', 'f'};
        int[] freq = {10, 50, 20, 40, 80};
        Map<Character, String> codes = buildCodes(chars, freq);
        System.out.println(codes);
    }

    public static Map<Character, String> buildCodes(char[] chars, int[] freq) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < chars.length; i++) {
            pq.offer(new Node(chars[i], freq[i]));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node newNode = new Node('$', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;
            pq.offer(newNode);
        }

        Node root = pq.poll();
        Map<Character, String> resCodes = new HashMap<>();
        buildCodes(root, resCodes, "");
        return resCodes;
    }

    public static void buildCodes(Node root, Map<Character, String> resCodes, String path) {
        if (isLeaf(root)) {
            resCodes.put(root.c, path);
            return;
        }
        buildCodes(root.left, resCodes, path + "0");
        buildCodes(root.right, resCodes, path + "1");
    }

    private static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }
}
