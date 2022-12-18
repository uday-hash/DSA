/*
 * Problem Description
Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.

Return the topological ordering of the graph and if it doesn't exist then return an empty array.

If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.

Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.

NOTE:

There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints
2 <= A <= 104

1 <= M <= min(100000,A*(A-1))

1 <= B[i][0], B[i][1] <= A
 */

package Graphs;

import java.util.*;

public class Topological_sort {
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < B.size(); i++) {
            graph.get(B.get(i).get(0) - 1).add(B.get(i).get(1) - 1);
        }
        boolean[] visited = new boolean[A];
        for (int i = 0; i < A; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, result);
            }
        }
        Collections.reverse(result);
        return result;
    }
    private void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true;
        for (int i = 0; i < graph.get(node).size(); i++) {
            if (!visited[graph.get(node).get(i)]) {
                dfs(graph.get(node).get(i), graph, visited, result);
            }
        }
        result.add(node + 1);
    }
}

