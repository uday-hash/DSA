/*
 * Problem Description
Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.

You have to find an integer array D of size A such that:

=> D[i] : Shortest distance form the C node to node i.

=> If node i is not reachable from C then -1.

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make sure to clear them.



Problem Constraints
1 <= A <= 1e5

0 <= B[i][0],B[i][1] < A

0 <= B[i][2] <= 1e3

0 <= C < A


 */

package Graphs;

import java.util.*;

public class Dijsktra {
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        ArrayList<Integer> D = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            D.add(Integer.MAX_VALUE);
        }
        D.set(C, 0);
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(1) - b.get(1));
        pq.add(new ArrayList<>(Arrays.asList(C, 0)));
        while (!pq.isEmpty()) {
            ArrayList<Integer> node = pq.poll();
            for (int i = 0; i < B.size(); i++) {
                if (B.get(i).get(0) == node.get(0)) {
                    int newDist = node.get(1) + B.get(i).get(2);
                    if (newDist < D.get(B.get(i).get(1))) {
                        D.set(B.get(i).get(1), newDist);
                        pq.add(new ArrayList<>(Arrays.asList(B.get(i).get(1), newDist)));
                    }
                }
                if (B.get(i).get(1) == node.get(0)) {
                    int newDist = node.get(1) + B.get(i).get(2);
                    if (newDist < D.get(B.get(i).get(0))) {
                        D.set(B.get(i).get(0), newDist);
                        pq.add(new ArrayList<>(Arrays.asList(B.get(i).get(0), newDist)));
                    }
                }
            }
        }
        for (int i = 0; i < A; i++) {
            if (D.get(i) == Integer.MAX_VALUE) {
                D.set(i, -1);
            }
        }
        return D;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(0, 1, 4)));
        B.add(new ArrayList<>(Arrays.asList(0, 7, 8)));
        B.add(new ArrayList<>(Arrays.asList(1, 2, 8)));
        B.add(new ArrayList<>(Arrays.asList(1, 7, 11)));
        B.add(new ArrayList<>(Arrays.asList(2, 3, 7)));
        B.add(new ArrayList<>(Arrays.asList(2, 8, 2)));
        B.add(new ArrayList<>(Arrays.asList(2, 5, 4)));
        B.add(new ArrayList<>(Arrays.asList(3, 4, 9)));
        B.add(new ArrayList<>(Arrays.asList(3, 5, 14)));
        B.add(new ArrayList<>(Arrays.asList(4, 5, 10)));
        B.add(new ArrayList<>(Arrays.asList(5, 6, 2)));
        B.add(new ArrayList<>(Arrays.asList(6, 7, 1)));
        B.add(new ArrayList<>(Arrays.asList(6, 8, 6)));
        B.add(new ArrayList<>(Arrays.asList(7, 8, 7)));
        System.out.println(new Dijsktra().solve(9, B, 0));
    }
}
    