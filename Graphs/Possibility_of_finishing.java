/*
 * Problem Description
There are a total of A courses you have to take, labeled from 1 to A.

Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].

So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.



Problem Constraints
1 <= A <= 6*104

1 <= length(B) = length(C) <= 105

1 <= B[i], C[i] <= A
 */
package Graphs;

import java.util.*;

public class Possibility_of_finishing {
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < B.size(); i++) {
            adj.get(B.get(i) - 1).add(C.get(i) - 1);
        }
        int[] visited = new int[A];
        for (int i = 0; i < A; i++) {
            if (visited[i] == 0) {
                if (isCyclic(adj, visited, i)) {
                    return 0;
                }
            }
        }
        return 1;
    }

    private boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int[] visited, int i) {
        if (visited[i] == 1) {
            return true;
        }
        if (visited[i] == 2) {
            return false;
        }
        visited[i] = 1;
        for (Integer v : adj.get(i)) {
            if (isCyclic(adj, visited, v)) {
                return true;
            }
        }
        visited[i] = 2;
        return false;
    }
}
    }
    
}
