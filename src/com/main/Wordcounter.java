package com.main;

import java.util.StringTokenizer;

public class Wordcounter {
    public static class WordCount {
        private String word;
        private int count;

        public WordCount(String word) {
            this.word = word;
            this.count = 1; // Initialize count to 1 for a new word.
        }

        public String getWord() {
            return word;
        }

        public int getCount() {
            return count;
        }

        public void incrementCount() {
            count++;
        }
    }

    private static final int DEFAULT_CAPACITY = 10;
    private static final double LOAD_FACTOR = 0.7;

    private WordCount[] table;
    private int size;
    private int capacity;

    public Wordcounter() {
        capacity = DEFAULT_CAPACITY;
        table = new WordCount[capacity];
        size = 0;
    }

    private int hash(String key) {
        return (key.hashCode() & 0x7FFFFFFF) % capacity;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        WordCount[] newTable = new WordCount[newCapacity];
        for (WordCount wordCount : table) {
            if (wordCount != null) {
                int index = hash(wordCount.getWord()) % newCapacity;
                while (newTable[index] != null) {
                    index = (index + 1) % newCapacity;
                }
                newTable[index] = wordCount;
            }
        }
        table = newTable;
        capacity = newCapacity;
    }

    public void put(String word) {
        if ((double) (size + 1) / capacity > LOAD_FACTOR) {
            resize();
        }
        int index = hash(word);
        while (table[index] != null) {
            if (table[index].getWord().equals(word)) {
                table[index].incrementCount();
                return;
            }
            index = (index + 1) % capacity;
        }
        table[index] = new WordCount(word);
        size++;
    }

    public int get(String word) {
        int index = hash(word);
        while (table[index] != null) {
            if (table[index].getWord().equals(word)) {
                return table[index].getCount();
            }
            index = (index + 1) % capacity;
        }
        return 0; // Word not found.
    }

    public static void main(String[] args) {
        String paragraph = "This code code - code - resizes the hash table when it reaches  load factor ";
        StringTokenizer tokenizer = new StringTokenizer(paragraph);

        Wordcounter wordFrequencyCounter = new Wordcounter();

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            wordFrequencyCounter.put(word);
        }

        System.out.println("Word Frequency Table:");
        for (WordCount wordCount : wordFrequencyCounter.table) {
            if (wordCount != null) {
                System.out.println("Word: " + wordCount.getWord() + "\t Length: " + wordCount.getWord().length() + " \t Frequency: " + wordCount.getCount() + " times");
            }
        }
    }
}