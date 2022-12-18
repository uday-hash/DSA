/*
Problem Description
Find largest distance Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes.

The goal of the problem is to find largest distance between two nodes in a tree. Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path between any pair of nodes since it is a tree).

The nodes will be numbered 0 through N - 1.

The tree is given as an array A, there is an edge between nodes A[i] and i (0 <= i < N). Exactly one of the i's will have A[i] equal to -1, it will be root node.



Problem Constraints
2 <= |A| <= 40000
*/


package Graphs;

import java.util.*;

public class Largest_distance_between_node_and_tree {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int root = -1;
        for(int i=0;i<n;i++){
            if(A.get(i) == -1){
                root = i;
            }else{
                adj.get(A.get(i)).add(i);
                adj.get(i).add(A.get(i));
            }
        }
        int[] depth = new int[n];
        depth[root] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=0;i<adj.get(x).size();i++){
                if(depth[adj.get(x).get(i)] == 0){
                    depth[adj.get(x).get(i)] = depth[x] + 1;
                    q.add(adj.get(x).get(i));
                }
            }
        }
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,depth[i]);
        }
        return max;

    }
}
