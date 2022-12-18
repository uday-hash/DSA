/*
 * Problem Description

Given a undirected weighted graph with A nodes labelled from 1 to A with M edges given in a form of 2D-matrix B of size M * 3 where B[i][0] and B[i][1] denotes the two nodes connected by an edge of weight B[i][2].

For each edge check whether it belongs to any of the possible minimum spanning tree or not , return 1 if it belongs else return 0.

Return an one-dimensional binary array of size M denoting answer for each edge.

NOTE:

The graph may be disconnected in that case consider mst for each component.
No self-loops and no multiple edges present.
Answers in output array must be in order with the input array B output[i] must denote the answer of edge B[i][0] to B[i][1].


Problem Constraints

1 <= A, M <= 3*105

1 <= B[i][0], B[i][1] <= A

1 <= B[i][1] <= 103
 */

package Graphs;

import java.util.*;

public class Edge_in_MST {
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        
    }
}
