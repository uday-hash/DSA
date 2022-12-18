/*
 * Problem Description

Given an undirected graph having A nodes labelled from 1 to A with M edges given in a form of matrix B of size M x 2 where (B[i][0], B[i][1]) represents two nodes B[i][0] and B[i][1] connected by an edge.

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain atleast three nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints

1 <= A, M <= 3*105

1 <= B[i][0], B[i][1] <= A
 */
package Graphs;

import java.util.*;

public class Cycle_in_undirected_graph {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < B.size(); i++) {
            adj.get(B.get(i).get(0) - 1).add(B.get(i).get(1) - 1);
            adj.get(B.get(i).get(1) - 1).add(B.get(i).get(0) - 1);
        }
        boolean[] visited = new boolean[A];
        for (int i = 0; i < A; i++) {
            if (!visited[i]) {
                if (isCyclic(adj, visited, i, -1)) {
                    return 1;
                }
            }
        }
        return 0;
        
    }
    
    private boolean isCyclic(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int src, int parent) {
        visited[src] = true;
        for (int i = 0; i < adj.get(src).size(); i++) {
            if (!visited[adj.get(src).get(i)]) {
                if (isCyclic(adj, visited, adj.get(src).get(i), src)) {
                    return true;
                }
            } else if (adj.get(src).get(i) != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Cycle_in_undirected_graph cug = new Cycle_in_undirected_graph();
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        ArrayList<Integer> B1 = new ArrayList<>();
        B1.add(1);
        B1.add(2);
        B.add(B1);
        ArrayList<Integer> B2 = new ArrayList<>();
        B2.add(2);
        B2.add(3);
        B.add(B2);
        ArrayList<Integer> B3 = new ArrayList<>();
        B3.add(3);
        B3.add(4);
        B.add(B3);
        ArrayList<Integer> B4 = new ArrayList<>();
        B4.add(4);
        B4.add(5);
        B.add(B4);
        ArrayList<Integer> B5 = new ArrayList<>();
        B5.add(1);
        B5.add(5);
        B.add(B5);
        System.out.println(cug.solve(5, B));
    }
}
