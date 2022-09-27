package Tries;

import java.util.ArrayList;

public class Shortest_unique_prefix {
    public ArrayList<String> prefix(ArrayList<String> A) {
        TrieNode root = new TrieNode();
        for (String word : A) {
            insert(root, word);
        }
        ArrayList<String> result = new ArrayList<>();
        for (String word : A) {
            result.add(getPrefix(root, word));
        }
        return result;
    }

    private void insert(TrieNode root, String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    private String getPrefix(TrieNode root, String word) {
        TrieNode current = root;
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            result += word.charAt(i);
            current = current.children[index];
            if (current.isEndOfWord) {
                break;
            }
        }
        return result;
    }
}
    
class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}