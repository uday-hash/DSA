/*
 * Problem Description
Given a undirected graph having A nodes. A matrix B of size M x 2 is given which represents the edges such that there is an edge between B[i][0] and B[i][1].

Find whether the given graph is bipartite or not.

A graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are Numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make sure to clear them.



Problem Constraints
1 <= A <= 100000

1 <= M <= min(A*(A-1)/2,200000)

0 <= B[i][0],B[i][1] < A
 */
package Graphs;

import java.util.*;

public class Check_bipartite_graph {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < B.size(); i++) {
            adj.get(B.get(i).get(0)).add(B.get(i).get(1));
            adj.get(B.get(i).get(1)).add(B.get(i).get(0));
        }
        int[] color = new int[A];
        for (int i = 0; i < A; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < A; i++) {
            if (color[i] == -1) {
                if (!isBipartite(adj, color, i)) {
                    return 0;
                }
            }
        }
        return 1;
    }

    private boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int[] color, int src) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src] = 1;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i = 0; i < adj.get(node).size(); i++) {
                if (color[adj.get(node).get(i)] == -1) {
                    color[adj.get(node).get(i)] = 1 - color[node];
                    q.add(adj.get(node).get(i));
                } else if (color[adj.get(node).get(i)] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}
