/*
 * Problem Description
There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.



Problem Constraints
1 <= A, M <= 6*104

1 <= B[i][0], B[i][1] <= A

1 <= B[i][2] <= 103
 */

package Graphs;

import java.util.*;

public class Commutable_islands {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<int[]>[] adj = new ArrayList[A];
        for(int i=0;i<A;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<B.size();i++){
            adj[B.get(i).get(0)-1].add(new int[]{B.get(i).get(1)-1,B.get(i).get(2)});
            adj[B.get(i).get(1)-1].add(new int[]{B.get(i).get(0)-1,B.get(i).get(2)});
        }
        boolean[] visited = new boolean[A];
        int cost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            if(visited[temp[0]] == false){
                visited[temp[0]] = true;
                cost += temp[1];
                for(int i=0;i<adj[temp[0]].size();i++){
                    pq.add(adj[temp[0]].get(i));
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        Commutable_islands obj = new Commutable_islands();
        int A = 4;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(1,2,1)));
        B.add(new ArrayList<>(Arrays.asList(2,3,4)));
        B.add(new ArrayList<>(Arrays.asList(1,4,3)));
        B.add(new ArrayList<>(Arrays.asList(4,3,2)));
        B.add(new ArrayList<>(Arrays.asList(1,3,10)));
        System.out.println(obj.solve(A,B));
    }
}
