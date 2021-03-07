package com.haridevelops.trie;

/** Holds only lower case letters */
public class BasicTrie {

    TrieNode root;
    
    /** Initialize your data structure here. */
    public BasicTrie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        int length = word.length();
        
        TrieNode temp = root;
        
        for (int i = 0; i < length; i++) {
            char ch = word.charAt(i);
            if (!temp.containsKey(ch)) {
                temp.put(ch, new TrieNode());
            }
            temp = temp.get(ch);
        }
        
        temp.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int length = word.length();
        
        TrieNode temp = root;
        
        for (int i = 0; i < length; i++) {
            char ch = word.charAt(i);
            if (temp.containsKey(ch)) {
                temp = temp.get(ch);
            } else return false;
        }
        return temp !=null && temp.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int length = prefix.length();
        
        TrieNode temp = root;
        
        for (int i = 0; i < length; i++) {
            char ch = prefix.charAt(i);
            if (temp.containsKey(ch)) {
                temp = temp.get(ch);
            } else return false;
        }
        return temp != null;
    }
    
    static class TrieNode {
        
        private TrieNode[] kids;
        
        private static int maxKids = 26;
        
        private boolean wordEnd;
        
        public TrieNode() {
            kids = new TrieNode[maxKids];
        }
        
        public TrieNode get(char ch) {
            return kids[ch-'a'];
        }
        
        public void put(char ch, TrieNode node) {
            kids[ch - 'a'] = node;
        }
        
        public boolean isEnd() {
            return wordEnd;
        }
        
        public void setEnd() {
            wordEnd = true;
        }
        
        public boolean containsKey(char ch) {
            return kids[ch - 'a'] != null;
        }
    }
}
