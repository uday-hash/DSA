/*
 * Problem Description
Given a matrix of integers A of size N x N, where A[i][j] represents the weight of directed edge from i to j (i ---> j).

If i == j, A[i][j] = 0, and if there is no directed edge from vertex i to vertex j, A[i][j] = -1.

Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j.

If there is no possible path from vertex i to vertex j , B[i][j] = -1

Note: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
1 <= N <= 200
-1 <= A[i][j] <= 1000000

 */
package Graphs;

import java.util.*;

public class Floyd_warshall_algorithm {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int[][] adj = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                adj[i][j] = A.get(i).get(j);
            }
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(adj[i][k] != -1 && adj[k][j] != -1){
                        if(adj[i][j] == -1){
                            adj[i][j] = adj[i][k] + adj[k][j];
                        }else{
                            adj[i][j] = Math.min(adj[i][j],adj[i][k] + adj[k][j]);
                        }
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0;j<n;j++){
                temp.add(adj[i][j]);
            }
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Floyd_warshall_algorithm fwa = new Floyd_warshall_algorithm();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(0);
        temp.add(1);
        temp.add(43);
        A.add(temp);
        temp = new ArrayList<>();
        temp.add(1);
        temp.add(0);
        temp.add(-1);
        A.add(temp);
        temp = new ArrayList<>();
        temp.add(-1);
        temp.add(0);
        temp.add(0);
        A.add(temp);
        System.out.println(fwa.solve(A));
    }
    
}
