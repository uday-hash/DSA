/*
 * Problem Description
Given a matrix of integers A of size N x M consisting of 0 or 1.

For each cell of the matrix find the distance of nearest 1 in the matrix.

Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - x2| + |y1 - y2|.

Find and return a matrix B of size N x M which defines for each cell in A distance of nearest 1 in the matrix A.

NOTE: There is atleast one 1 is present in the matrix.



Problem Constraints
1 <= N, M <= 1000

0 <= A[i][j] <= 1
 */
package Graphs;

import java.util.*;

public class Distance_of_nearest_cell {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int[][] adj = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                adj[i][j] = A.get(i).get(j);
            }
        }
        boolean[][] visited = new boolean[n][m];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>());
            for(int j=0;j<m;j++){
                ans.get(i).add(-1);
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(adj[i][j] == 1){
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                    ans.get(i).set(j,0);
                }
            }
        }
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int i=0;i<4;i++){
                int x = temp[0] + dx[i];
                int y = temp[1] + dy[i];
                if(x>=0 && y>=0 && x<n && y<m && !visited[x][y]){
                    visited[x][y] = true;
                    q.add(new int[]{x,y});
                    ans.get(x).set(y,ans.get(temp[0]).get(temp[1])+1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Distance_of_nearest_cell doc = new Distance_of_nearest_cell();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> A1 = new ArrayList<>();
        A1.add(0);
        A1.add(0);
        A1.add(0);
        A1.add(1);
        A.add(A1);
        ArrayList<Integer> A2 = new ArrayList<>();
        A2.add(0);
        A2.add(0);
        A2.add(1);
        A2.add(1);
        A.add(A2);
        ArrayList<Integer> A3 = new ArrayList<>();
        A3.add(0);
        A3.add(1);
        A3.add(1);
        A3.add(0);
        A.add(A3);
        System.out.println(doc.solve(A));
    }
}
