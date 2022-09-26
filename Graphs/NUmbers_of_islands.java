/*
 * Problem Description
Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.

More formally, from any cell (i, j) if A[i][j] = 1 you can visit:

(i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
(i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
(i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
(i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
(i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
(i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
(i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
(i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
Return the number of islands.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
1 <= N, M <= 100

0 <= A[i] <= 1
 */

package Graphs;

import java.util.ArrayList;

public class NUmbers_of_islands {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int[][] adj = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                adj[i][j] = A.get(i).get(j);
            }
        }
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(adj[i][j] == 1 && !visited[i][j]){
                    dfs(i,j,adj,visited);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int i,int j,int[][] adj,boolean[][] visited){
        if(i<0 || j<0 || i>=adj.length || j>=adj[0].length || adj[i][j] == 0 || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        dfs(i-1,j,adj,visited);
        dfs(i,j-1,adj,visited);
        dfs(i+1,j,adj,visited);
        dfs(i,j+1,adj,visited);
        dfs(i-1,j-1,adj,visited);
        dfs(i+1,j+1,adj,visited);
        dfs(i-1,j+1,adj,visited);
        dfs(i+1,j-1,adj,visited);
    }
}


