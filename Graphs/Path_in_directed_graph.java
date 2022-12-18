/*
 * Problem Description
Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node

B[i][0] to node B[i][1].

Find whether a path exists from node 1 to node A.

Return 1 if path exists else return 0.

NOTE:

There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints
2 <= A <= 105

1 <= M <= min(200000,A*(A-1))

1 <= B[i][0], B[i][1] <= A


 */

package Graphs;

import java.util.ArrayList;

public class Path_in_directed_graph {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int n = B.size();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<A;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int u = B.get(i).get(0)-1;
            int v = B.get(i).get(1)-1;
            adj.get(u).add(v);
        }
        boolean[] visited = new boolean[A];
        return dfs(0,A-1,adj,visited);

    }
    public int dfs(int src,int dest,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        if(src == dest){
            return 1;
        }
        visited[src] = true;
        for(int i=0;i<adj.get(src).size();i++){
            int v = adj.get(src).get(i);
            if(!visited[v]){
                if(dfs(v,dest,adj,visited) == 1){
                    return 1;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Path_in_directed_graph obj = new Path_in_directed_graph();
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        B.add(temp);
        temp = new ArrayList<>();
        temp.add(4);
        temp.add(1);
        B.add(temp);
        temp = new ArrayList<>();
        temp.add(2);
        temp.add(4);
        B.add(temp);
        temp = new ArrayList<>();
        temp.add(3);
        temp.add(4);
        B.add(temp);
        temp = new ArrayList<>();
        temp.add(5);
        temp.add(2);
        B.add(temp);
        temp = new ArrayList<>();
        temp.add(1);
        temp.add(3);
        B.add(temp);
        System.out.println(obj.solve(5,B));    
    }

}
