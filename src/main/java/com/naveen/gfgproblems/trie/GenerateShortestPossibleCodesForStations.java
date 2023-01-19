package com.naveen.gfgproblems.trie;


import java.util.TreeMap;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Trie/problem/renaming-cities28581833
public class GenerateShortestPossibleCodesForStations {
    private static class Node {
        boolean isEndOfWord;
        TreeMap<Character, Node> mp = new TreeMap<>();
    }
    public static void check(String cities[],int n)
    {
        Node root = new Node();
        for (String city : cities) {
            Node cur = root;
            StringBuilder sb = new StringBuilder();
            boolean appendable = true;

            for (char c : city.toCharArray()) {
                if (appendable) {
                    sb.append(c);
                }
                if (cur.mp.get(c) == null) {
                    cur.mp.put(c, new Node());
                    appendable = false;
                }
                cur = cur.mp.get(c);
            }
            String code = sb.toString();
            if (code.equals(city) && cur.isEndOfWord) {
                code = code + " 2";
            }
            cur.isEndOfWord = true;
            System.out.println(code);
        }
    }
}
