package Tries;

import java.util.*;

public class Shortest_unique_prefix {
    public ArrayList<String> prefix(ArrayList<String> A) {
        Trie trie = new Trie();
        for (int i = 0; i < A.size(); i++) {
            trie.insert(A.get(i));
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            ans.add(trie.getPrefix(A.get(i)));
        }
        return ans;
    }
    class TrieNode {
        Map<Character, TrieNode> map;
        boolean isEnd;
        int count;
        public TrieNode() {
            map = new HashMap<>();
            isEnd = false;
            count = 0;
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
                curr.count++;
            }
            curr.isEnd = true;
        }
        public String getPrefix(String word) {
            TrieNode curr = root;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                sb.append(c);
                curr = curr.map.get(c);
                if (curr.count == 1) {
                    return sb.toString();
                }
            }
            return "";
        }
    }

    public static void main(String[] args) {
        Shortest_unique_prefix obj = new Shortest_unique_prefix();
        ArrayList<String> A = new ArrayList<>();
        A.add("zebra");
        A.add("dog");
        A.add("duck");
        A.add("dove");
        System.out.println(obj.prefix(A));
    }
}
    