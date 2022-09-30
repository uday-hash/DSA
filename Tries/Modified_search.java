/*
 * Problem Description

Given two arrays of strings A of size N and B of size M.

Return a binary string C where C[i] = '1' if B[i] can be found in dictionary A using exactly one modification in B[i], Else C[i] = '0'.

NOTE: modification is defined as converting a character into another character.



Problem Constraints

1 <= N <= 30000

1 <= M <= 2500

1 <= length of any string either in A or B <= 20

strings contains only lowercase alphabets
 */
package Tries;

import java.util.*;

public class Modified_search {
    public String solve(ArrayList<String> A, ArrayList<String> B) {
        Trie trie = new Trie();
        for (int i = 0; i < A.size(); i++) {
            trie.insert(A.get(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < B.size(); i++) {
            sb.append(solve(trie, B.get(i)));
        }
        return sb.toString();
    }
    public char solve(Trie trie, String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != s.charAt(i)) {
                    char temp = s.charAt(i);
                    s = s.substring(0, i) + c + s.substring(i + 1);
                    if (trie.search(s)) {
                        return '1';
                    }
                    s = s.substring(0, i) + temp + s.substring(i + 1);
                }
            }
        }
        return '0';
    }

    class TrieNode {
        Map<Character, TrieNode> map;
        boolean isEnd;
        public TrieNode() {
            map = new HashMap<>();
            isEnd = false;
        }
    }

    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void insert(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!curr.map.containsKey(c)) {
                    curr.map.put(c, new TrieNode());
                }
                curr = curr.map.get(c);
            }
            curr.isEnd = true;
        }
        public boolean search(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!curr.map.containsKey(c)) {
                    return false;
                }
                curr = curr.map.get(c);
            }
            return curr.isEnd;
        }
    }
    public static void main(String[] args) {
        Modified_search m = new Modified_search();
        ArrayList<String> A = new ArrayList<>();
        A.add("abb");
        A.add("abc");
        A.add("aba");
        A.add("abca");
        ArrayList<String> B = new ArrayList<>();
        B.add("abc");
        B.add("abca");
        B.add("abca");
        B.add("abca");
        B.add("abca");
        B.add("abca");
        B.add("abca");
        System.out.println(m.solve(A, B));
    }
}
    
