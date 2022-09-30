/*
 * Problem Description

We want to make a custom contacts finder applications as part of our college project. The application must perform two types of operations:

Type 1: Add name B[i] ,denoted by 0 in vector A where B[i] is a string in vector B denoting a contact name. This must store B[i] as a new contact in the application.

Type 2: Find partial for B[i] ,denoted by 1 in vector A where B[i] is a string in vector B denoting a partial name to search the application for. It must count the number of contacts starting with B[i].

You have been given sequential add and find operations. You need to perform each operation in order.

And return as an array of integers, answers for each query of type 2(denoted by 1 in A) .



Problem Constraints

1 <= |A| <= 10000

1 <= |length of strings in B| <= 10
 */

package Tries;

import java.util.*;

public class Contact_finder {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B) {
        Trie trie = new Trie();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 0) {
                trie.insert(B.get(i));
            } else {
                ans.add(trie.count(B.get(i)));
            }
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
        public int count(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!curr.map.containsKey(c)) {
                    return 0;
                }
                curr = curr.map.get(c);
            }
            return curr.count;
        }        
    }
}
