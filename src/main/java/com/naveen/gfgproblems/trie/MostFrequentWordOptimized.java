package com.naveen.gfgproblems.trie;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentWordOptimized {

    public static void main(String[] args) {
        String[] words = {"xejdcj", "xejdcj", "lvjpb", "tmyuiu", "lvjpb", "tmyuiu", "ovoba", "lvjpb", "lvjpb", "fqhyu", "fqhyu", "tmyuiu", "xejdcj", "tmyuiu", "fqhyu", "ovoba", "xejdcj"};
        System.out.println(mostFrequentWord(words, words.length));
    }

    public static String mostFrequentWord(String words[],int n) {
        Map<String, Element> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int index = i;
            freqMap.computeIfAbsent(words[i], word -> new Element(word, index)).count++;
        }
        return Collections.max(freqMap.values()).word;
    }

    private static class Element implements Comparable<Element> {
        private String word;
        private int count;
        private final int firstIndex;
        public Element(String word, int index) {
            this.word = word;
            this.firstIndex = index;
        }

        public int compareTo(Element o) {
            if (count != o.count) {
                return count - o.count;
            }
            return firstIndex - o.firstIndex;
        }
    }
}
